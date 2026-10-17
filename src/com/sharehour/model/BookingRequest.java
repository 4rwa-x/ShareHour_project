package com.sharehour.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class BookingRequest {
    private String renterId;
    private String toolId;
    private LocalDate rentalDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private double hourlyPrice;

    public BookingRequest(String renterId, String toolId, LocalDate rentalDate, 
                          LocalTime startTime, LocalTime endTime, double hourlyPrice) {
        this.renterId = renterId;
        this.toolId = toolId;
        this.rentalDate = rentalDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.hourlyPrice = hourlyPrice;
    }

    public String getRenterId() { return renterId; }
    public String getToolId() { return toolId; }
    public LocalDate getRentalDate() { return rentalDate; }
    public LocalTime getStartTime() { return startTime; }
    public LocalTime getEndTime() { return endTime; }
    public double getHourlyPrice() { return hourlyPrice; }
}