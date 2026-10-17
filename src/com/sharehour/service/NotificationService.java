package com.sharehour.service;

import com.sharehour.model.Booking;

public class NotificationService {

    public void notifyOwnerPendingRequest(Booking booking) {
        System.out.println("[NOTIFICATION] Owner notified: New pending booking request #" + booking.getBookingId());
    }

    public void notifyRenterStatusChange(Booking booking, String newStatus) {
        System.out.println("[NOTIFICATION] Renter notified: Booking #" + booking.getBookingId() + " status is now " + newStatus);
    }
}