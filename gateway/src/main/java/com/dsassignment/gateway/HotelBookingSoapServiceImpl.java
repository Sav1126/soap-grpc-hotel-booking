package com.dsassignment.gateway;

import com.dsassignment.grpc.AvailabilityRequest;
import com.dsassignment.grpc.AvailabilityResponse;
import com.dsassignment.grpc.BookingRequest;
import com.dsassignment.grpc.CancelRequest;
import com.dsassignment.grpc.HotelBookingServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;

import javax.jws.WebService;

@WebService(
        serviceName = "HotelBookingSoapService",
        endpointInterface = "com.dsassignment.gateway.HotelBookingSoapService"
)
public class HotelBookingSoapServiceImpl implements HotelBookingSoapService {

    private final HotelBookingServiceGrpc.HotelBookingServiceBlockingStub grpcStub;

    public HotelBookingSoapServiceImpl(ManagedChannel channel) {
        this.grpcStub = HotelBookingServiceGrpc.newBlockingStub(channel);
    }

    @Override
    public CheckAvailabilityResponse checkAvailability(String hotelId, String roomType, String checkIn, String checkOut) throws GatewayFault {
        try {
            AvailabilityRequest request = AvailabilityRequest.newBuilder()
                    .setHotelId(hotelId)
                    .setRoomType(roomType)
                    .setCheckIn(checkIn)
                    .setCheckOut(checkOut)
                    .build();

            AvailabilityResponse grpcResponse = grpcStub.checkAvailability(request);

            return new CheckAvailabilityResponse(
                    grpcResponse.getAvailable(),
                    grpcResponse.getRoomsAvailable(),
                    grpcResponse.getPricePerNight()
            );

        } catch (StatusRuntimeException e) {
            throw mapGrpcErrorToSoapFault(e);
        }
    }

    @Override
    public BookingResponse bookRoom(String hotelId, String roomType, String checkIn, String checkOut, String guestName) throws GatewayFault {
        try {
            BookingRequest request = BookingRequest.newBuilder()
                    .setHotelId(hotelId)
                    .setRoomType(roomType)
                    .setCheckIn(checkIn)
                    .setCheckOut(checkOut)
                    .setGuestName(guestName)
                    .build();

            // Fully qualified: avoids clash with com.dsassignment.gateway.BookingResponse
            com.dsassignment.grpc.BookingResponse grpcResponse = grpcStub.bookRoom(request);

            return new BookingResponse(
                    grpcResponse.getBookingId(),
                    grpcResponse.getStatus(),
                    grpcResponse.getTotalPrice()
            );

        } catch (StatusRuntimeException e) {
            throw mapGrpcErrorToSoapFault(e);
        }
    }

    @Override
    public CancelResponse cancelBooking(String bookingId) throws GatewayFault {
        try {
            CancelRequest request = CancelRequest.newBuilder()
                    .setBookingId(bookingId)
                    .build();

            // Fully qualified: avoids clash with com.dsassignment.gateway.CancelResponse
            com.dsassignment.grpc.CancelResponse grpcResponse = grpcStub.cancelBooking(request);

            return new CancelResponse(
                    grpcResponse.getSuccess(),
                    grpcResponse.getMessage()
            );

        } catch (StatusRuntimeException e) {
            throw mapGrpcErrorToSoapFault(e);
        }
    }

    /**
     * Core translation logic: converts a gRPC error (Status code + description)
     * into a structured SOAP fault carrying the same information, so the SOAP
     * client sees a proper <soap:Fault> instead of a raw connection error.
     */
    private GatewayFault mapGrpcErrorToSoapFault(StatusRuntimeException e) {
        Status status = e.getStatus();
        String code = status.getCode().name();
        String description = status.getDescription() != null ? status.getDescription() : "Unknown gRPC error";

        GatewayFaultInfo faultInfo = new GatewayFaultInfo(code, description);
        return new GatewayFault("Gateway translation error [" + code + "]: " + description, faultInfo, e);
    }
}