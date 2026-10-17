package com.sharehour.service;

import com.sharehour.model.BookingRequest;
import java.time.Duration;

public class RentalCostCalculator {

    public double calculate(BookingRequest request) {
        long minutes = Duration.between(request.getStartTime(), request.getEndTime()).toMinutes();
        double hours = minutes / 60.0;
        return hours * request.getHourlyPrice();
    }
}