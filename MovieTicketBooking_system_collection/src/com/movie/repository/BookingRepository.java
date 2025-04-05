package com.movie.repository;

import java.util.ArrayList;
import java.util.List;

import com.movie.entity.Booking;

public class BookingRepository {
    List<Booking> bookings = new ArrayList<Booking>();
    int count = 0;

    public void bookTicket(Booking booking) {
        if (count < bookings.size()) {
            bookings.add(booking);
        }
    }
}