package com.movie.repository;

import com.movie.entity.Booking;

public class BookingRepository {
    Booking[] bookings = new Booking[10];
    int count = 0;

    public void bookTicket(Booking booking) {
        if (count < bookings.length) {
            bookings[count++] = booking;
        }
    }
}