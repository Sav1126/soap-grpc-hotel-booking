package com.dsassignment.gateway;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "BookingResult")
public class BookingResponse {
    private String bookingId;
    private String status;
    private double totalPrice;

    public BookingResponse() {}

    public BookingResponse(String bookingId, String status, double totalPrice) {
        this.bookingId = bookingId;
        this.status = status;
        this.totalPrice = totalPrice;
    }

    public String getBookingId() { return bookingId; }
    public void setBookingId(String bookingId) { this.bookingId = bookingId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public double getTotalPrice() { return totalPrice; }
    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }
}
