package com.dsassignment.gateway;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(name = "HotelBookingSoapService", targetNamespace = "http://gateway.dsassignment.com/")
public interface HotelBookingSoapService {

    @WebMethod
    @WebResult(name = "checkAvailabilityResponse")
    CheckAvailabilityResponse checkAvailability(
            @WebParam(name = "hotelId") String hotelId,
            @WebParam(name = "roomType") String roomType,
            @WebParam(name = "checkIn") String checkIn,
            @WebParam(name = "checkOut") String checkOut
    ) throws GatewayFault;

    @WebMethod
    @WebResult(name = "bookingResponse")
    BookingResponse bookRoom(
            @WebParam(name = "hotelId") String hotelId,
            @WebParam(name = "roomType") String roomType,
            @WebParam(name = "checkIn") String checkIn,
            @WebParam(name = "checkOut") String checkOut,
            @WebParam(name = "guestName") String guestName
    ) throws GatewayFault;

    @WebMethod
    @WebResult(name = "cancelResponse")
    CancelResponse cancelBooking(
            @WebParam(name = "bookingId") String bookingId
    ) throws GatewayFault;
}