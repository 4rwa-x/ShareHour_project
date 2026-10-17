package com.sharehour.service;

import com.sharehour.model.BookingRequest;
import java.time.LocalDate;

public class BookingValidator {

    public void validate(BookingRequest request) throws IllegalArgumentException {
        if (request == null) {
            throw new IllegalArgumentException("Booking request cannot be null.");
        }
        if (request.getRentalDate() == null || request.getRentalDate().isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Invalid or past rental date.");
        }
        if (request.getStartTime() == null || request.getEndTime() == null) {
            throw new IllegalArgumentException("Start time and end time must be specified.");
        }
        if (!request.getEndTime().isAfter(request.getStartTime())) {
            throw new IllegalArgumentException("End time must be after start time.");
        }
        if (request.getHourlyPrice() <= 0) {
            throw new IllegalArgumentException("Hourly price must be greater than zero.");
        }
    }
}