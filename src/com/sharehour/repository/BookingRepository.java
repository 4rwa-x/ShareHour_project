package com.sharehour.repository;

import com.sharehour.model.Booking;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class BookingRepository {
    private final Map<Long, Booking> database = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public long save(Booking booking) {
        long id = idGenerator.getAndIncrement();
        booking.setBookingId(id);
        database.put(id, booking);
        System.out.println("[SQL INSERT] Saved Booking ID: " + id);
        return id;
    }

    public Booking findById(long id) {
        return database.get(id);
    }

    public void updateStatus(long id, String status) {
        Booking booking = database.get(id);
        if (booking != null) {
            booking.setStatus(status);
        }
    }
}