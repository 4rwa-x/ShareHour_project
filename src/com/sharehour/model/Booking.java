package com.sharehour.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Booking {
    private long bookingId;
    private String renterId;
    private String toolId;
    private double totalCost;
    private LocalDate rentalDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Booking(long bookingId, String renterId, String toolId, double totalCost,
                   LocalDate rentalDate, LocalTime startTime, LocalTime endTime, String status) {
        this.bookingId = bookingId;
        this.renterId = renterId;
        this.toolId = toolId;
        this.totalCost = totalCost;
        this.rentalDate = rentalDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public long getBookingId() { return bookingId; }
    public void setBookingId(long bookingId) { this.bookingId = bookingId; }
    public String getRenterId() { return renterId; }
    public String getToolId() { return toolId; }
    public double getTotalCost() { return totalCost; }
    public LocalDate getRentalDate() { return rentalDate; }
    public LocalTime getStartTime() { return startTime; }
    public LocalTime getEndTime() { return endTime; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}