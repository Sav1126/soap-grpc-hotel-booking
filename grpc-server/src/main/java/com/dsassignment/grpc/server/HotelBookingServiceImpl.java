package com.dsassignment.grpc.server;

import com.dsassignment.grpc.*;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class HotelBookingServiceImpl extends HotelBookingServiceGrpc.HotelBookingServiceImplBase {

    private static final Set<String> VALID_ROOM_TYPES = Set.of("SINGLE", "DOUBLE", "SUITE");

    private final Map<String, Map<String, int[]>> inventory = new ConcurrentHashMap<>();
    private final Map<String, Map<String, Double>> prices = new ConcurrentHashMap<>();
    private final Map<String, BookingRecord> bookings = new ConcurrentHashMap<>();

    private static class BookingRecord {
        String hotelId;
        String roomType;
        boolean cancelled = false;
    }

    public HotelBookingServiceImpl() {
        inventory.put("H1", new HashMap<>(Map.of(
                "SINGLE", new int[]{5},
                "DOUBLE", new int[]{3},
                "SUITE", new int[]{1}
        )));
        prices.put("H1", new HashMap<>(Map.of(
                "SINGLE", 50.0,
                "DOUBLE", 80.0,
                "SUITE", 150.0
        )));

        inventory.put("H2", new HashMap<>(Map.of(
                "SINGLE", new int[]{2},
                "DOUBLE", new int[]{0},
                "SUITE", new int[]{2}
        )));
        prices.put("H2", new HashMap<>(Map.of(
                "SINGLE", 40.0,
                "DOUBLE", 70.0,
                "SUITE", 130.0
        )));
    }

    @Override
    public void checkAvailability(AvailabilityRequest request, StreamObserver<AvailabilityResponse> responseObserver) {
        try {
            validateHotelId(request.getHotelId());
            validateRoomType(request.getRoomType());
            LocalDate checkIn = parseDate(request.getCheckIn(), "check_in");
            LocalDate checkOut = parseDate(request.getCheckOut(), "check_out");
            validateDateRange(checkIn, checkOut);

            Map<String, int[]> hotelRooms = inventory.get(request.getHotelId());
            int available = hotelRooms.get(request.getRoomType())[0];
            double price = prices.get(request.getHotelId()).get(request.getRoomType());

            AvailabilityResponse response = AvailabilityResponse.newBuilder()
                    .setAvailable(available > 0)
                    .setRoomsAvailable(available)
                    .setPricePerNight(price)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();

        } catch (StatusRuntimeValidationException e) {
            responseObserver.onError(e.toStatusException());
        }
    }

    @Override
    public void bookRoom(BookingRequest request, StreamObserver<BookingResponse> responseObserver) {
        try {
            validateHotelId(request.getHotelId());
            validateRoomType(request.getRoomType());
            LocalDate checkIn = parseDate(request.getCheckIn(), "check_in");
            LocalDate checkOut = parseDate(request.getCheckOut(), "check_out");
            validateDateRange(checkIn, checkOut);

            if (request.getGuestName() == null || request.getGuestName().isBlank()) {
                throw new StatusRuntimeValidationException(Status.INVALID_ARGUMENT, "guest_name must not be empty");
            }

            int[] roomCount = inventory.get(request.getHotelId()).get(request.getRoomType());
            if (roomCount[0] <= 0) {
                throw new StatusRuntimeValidationException(Status.FAILED_PRECONDITION,
                        "No rooms of type " + request.getRoomType() + " available at hotel " + request.getHotelId());
            }

            roomCount[0] -= 1;

            long nights = java.time.temporal.ChronoUnit.DAYS.between(checkIn, checkOut);
            double pricePerNight = prices.get(request.getHotelId()).get(request.getRoomType());
            double total = nights * pricePerNight;

            String bookingId = UUID.randomUUID().toString();
            BookingRecord record = new BookingRecord();
            record.hotelId = request.getHotelId();
            record.roomType = request.getRoomType();
            bookings.put(bookingId, record);

            BookingResponse response = BookingResponse.newBuilder()
                    .setBookingId(bookingId)
                    .setStatus("CONFIRMED")
                    .setTotalPrice(total)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();

        } catch (StatusRuntimeValidationException e) {
            responseObserver.onError(e.toStatusException());
        }
    }

    @Override
    public void cancelBooking(CancelRequest request, StreamObserver<CancelResponse> responseObserver) {
        try {
            if (request.getBookingId() == null || request.getBookingId().isBlank()) {
                throw new StatusRuntimeValidationException(Status.INVALID_ARGUMENT, "booking_id must not be empty");
            }

            BookingRecord record = bookings.get(request.getBookingId());
            if (record == null) {
                throw new StatusRuntimeValidationException(Status.NOT_FOUND,
                        "No booking found with id " + request.getBookingId());
            }

            if (record.cancelled) {
                throw new StatusRuntimeValidationException(Status.FAILED_PRECONDITION,
                        "Booking " + request.getBookingId() + " is already cancelled");
            }

            record.cancelled = true;
            inventory.get(record.hotelId).get(record.roomType)[0] += 1;

            CancelResponse response = CancelResponse.newBuilder()
                    .setSuccess(true)
                    .setMessage("Booking cancelled successfully")
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();

        } catch (StatusRuntimeValidationException e) {
            responseObserver.onError(e.toStatusException());
        }
    }

    private void validateHotelId(String hotelId) {
        if (hotelId == null || hotelId.isBlank()) {
            throw new StatusRuntimeValidationException(Status.INVALID_ARGUMENT, "hotel_id must not be empty");
        }
        if (!inventory.containsKey(hotelId)) {
            throw new StatusRuntimeValidationException(Status.NOT_FOUND, "Unknown hotel_id: " + hotelId);
        }
    }

    private void validateRoomType(String roomType) {
        if (roomType == null || roomType.isBlank()) {
            throw new StatusRuntimeValidationException(Status.INVALID_ARGUMENT, "room_type must not be empty");
        }
        if (!VALID_ROOM_TYPES.contains(roomType.toUpperCase())) {
            throw new StatusRuntimeValidationException(Status.INVALID_ARGUMENT,
                    "room_type must be one of " + VALID_ROOM_TYPES);
        }
    }

    private LocalDate parseDate(String dateStr, String fieldName) {
        try {
            return LocalDate.parse(dateStr);
        } catch (DateTimeParseException | NullPointerException e) {
            throw new StatusRuntimeValidationException(Status.INVALID_ARGUMENT,
                    fieldName + " must be a valid date in format YYYY-MM-DD");
        }
    }

    private void validateDateRange(LocalDate checkIn, LocalDate checkOut) {
        if (!checkOut.isAfter(checkIn)) {
            throw new StatusRuntimeValidationException(Status.INVALID_ARGUMENT,
                    "check_out must be after check_in");
        }
        if (checkIn.isBefore(LocalDate.now())) {
            throw new StatusRuntimeValidationException(Status.INVALID_ARGUMENT,
                    "check_in must not be in the past");
        }
    }
}