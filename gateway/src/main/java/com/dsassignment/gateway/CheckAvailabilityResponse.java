package com.dsassignment.gateway;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "CheckAvailabilityResult")
public class CheckAvailabilityResponse {
    private boolean available;
    private int roomsAvailable;
    private double pricePerNight;

    public CheckAvailabilityResponse() {}

    public CheckAvailabilityResponse(boolean available, int roomsAvailable, double pricePerNight) {
        this.available = available;
        this.roomsAvailable = roomsAvailable;
        this.pricePerNight = pricePerNight;
    }

    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    public int getRoomsAvailable() { return roomsAvailable; }
    public void setRoomsAvailable(int roomsAvailable) { this.roomsAvailable = roomsAvailable; }

    public double getPricePerNight() { return pricePerNight; }
    public void setPricePerNight(double pricePerNight) { this.pricePerNight = pricePerNight; }
}