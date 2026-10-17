package com.sharehour.service;

import com.sharehour.model.Booking;
import com.sharehour.model.BookingRequest;
import com.sharehour.repository.BookingRepository;

public class BookingManager {
    private final BookingRepository repository;
    private final NotificationService notificationService;
    private final BookingQuoteService quoteService;

    public BookingManager(BookingRepository repository, NotificationService notificationService, BookingQuoteService quoteService) {
        this.repository = repository;
        this.notificationService = notificationService;
        this.quoteService = quoteService;
    }

    public Booking processBooking(BookingRequest request) {
        double totalCost = quoteService.calculateQuote(request);

        Booking booking = new Booking(
                0,
                request.getRenterId(),
                request.getToolId(),
                totalCost,
                request.getRentalDate(),
                request.getStartTime(),
                request.getEndTime(),
                "PENDING"
        );

        repository.save(booking);
        notificationService.notifyOwnerPendingRequest(booking);

        return booking;
    }
}