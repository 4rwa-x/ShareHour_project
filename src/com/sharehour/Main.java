package com.sharehour;

import com.sharehour.model.Booking;
import com.sharehour.model.BookingRequest;
import com.sharehour.repository.BookingRepository;
import com.sharehour.service.*;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   SHARE HOUR SYSTEM - COMPONENT INTEGRATION TEST  ");
        System.out.println("==================================================");

        // 1. Initialize Logic Component A
        BookingValidator validator = new BookingValidator();
        RentalCostCalculator calculator = new RentalCostCalculator();
        BookingQuoteService quoteService = new BookingQuoteService(validator, calculator);

        // 2. Initialize Logic Component B
        BookingRepository repository = new BookingRepository();
        NotificationService notificationService = new NotificationService();
        BookingManager bookingManager = new BookingManager(repository, notificationService, quoteService);

        // 3. Create Sample Booking Request (Matching Report Example)
        System.out.println("\n[1] Incoming Booking Request:");
        BookingRequest request = new BookingRequest(
                "renter_ahmed",
                "tool_drill_101",
                LocalDate.of(2026, 10, 20),
                LocalTime.of(10, 0),
                LocalTime.of(13, 0),
                5.0 // 5.0 OMR / hr
        );

        System.out.println("    - Renter ID : " + request.getRenterId());
        System.out.println("    - Tool ID   : " + request.getToolId());
        System.out.println("    - Date      : " + request.getRentalDate());
        System.out.println("    - Time      : " + request.getStartTime() + " - " + request.getEndTime() + " (3 Hours)");

        // 4. Process Request
        System.out.println("\n[2] Executing Component A (Validation & Cost) and Component B (Management)...");
        Booking booking = bookingManager.processBooking(request);

        // 5. Output Result
        System.out.println("\n==================================================");
        System.out.println("   BOOKING PROCESSED SUCCESSFULLY");
        System.out.println("==================================================");
        System.out.println("    Booking ID : #" + booking.getBookingId());
        System.out.println("    Total Cost : " + booking.getTotalCost() + " OMR");
        System.out.println("    Status     : " + booking.getStatus());
        System.out.println("==================================================");
    }
}
