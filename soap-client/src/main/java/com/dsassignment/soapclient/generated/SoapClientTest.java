package com.dsassignment.soapclient.generated;

import com.dsassignment.soapclient.generated.*;

public class SoapClientTest {

    public static void main(String[] args) {
        HotelBookingSoapService_Service serviceLocator = new HotelBookingSoapService_Service();
        HotelBookingSoapService client = serviceLocator.getHotelBookingSoapServiceImplPort();

        System.out.println("========== TEST 1: Check Availability (valid) ==========");
        try {
            CheckAvailabilityResult availability = client.checkAvailability("H1", "DOUBLE", "2026-12-01", "2026-12-05");
            System.out.println("Available: " + availability.isAvailable());
            System.out.println("Rooms available: " + availability.getRoomsAvailable());
            System.out.println("Price per night: " + availability.getPricePerNight());
        } catch (GatewayFault fault) {
            printFault(fault);
        }

        System.out.println("\n========== TEST 2: Book a Room (valid) ==========");
        String bookingIdToCancel = null;
        try {
            BookingResult booking = client.bookRoom("H1", "DOUBLE", "2026-12-01", "2026-12-05", "John Doe");
            System.out.println("Booking ID: " + booking.getBookingId());
            System.out.println("Status: " + booking.getStatus());
            System.out.println("Total price: " + booking.getTotalPrice());
            bookingIdToCancel = booking.getBookingId();
        } catch (GatewayFault fault) {
            printFault(fault);
        }

        System.out.println("\n========== TEST 3: Cancel Booking (valid) ==========");
        if (bookingIdToCancel != null) {
            try {
                CancelResult cancel = client.cancelBooking(bookingIdToCancel);
                System.out.println("Success: " + cancel.isSuccess());
                System.out.println("Message: " + cancel.getMessage());
            } catch (GatewayFault fault) {
                printFault(fault);
            }
        }

        System.out.println("\n========== TEST 4: Check Availability with INVALID hotel (expects SOAP Fault) ==========");
        try {
            client.checkAvailability("UNKNOWN_HOTEL", "DOUBLE", "2026-12-01", "2026-12-05");
        } catch (GatewayFault fault) {
            System.out.println("Correctly received SOAP Fault:");
            printFault(fault);
        }

        System.out.println("\n========== TEST 5: Book Room with invalid date range (expects SOAP Fault) ==========");
        try {
            client.bookRoom("H1", "DOUBLE", "2026-12-05", "2026-12-01", "Jane Doe");
        } catch (GatewayFault fault) {
            System.out.println("Correctly received SOAP Fault:");
            printFault(fault);
        }

        System.out.println("\n========== TEST 6: Cancel a non-existent booking (expects SOAP Fault) ==========");
        try {
            client.cancelBooking("non-existent-id-123");
        } catch (GatewayFault fault) {
            System.out.println("Correctly received SOAP Fault:");
            printFault(fault);
        }
    }

    private static void printFault(GatewayFault fault) {
        System.out.println("Fault message: " + fault.getMessage());
        try {
            Object faultInfo = fault.getFaultInfo();
            System.out.println("Fault info: " + faultInfo);
        } catch (Exception e) {
            // ignore if method name differs
        }
    }
}