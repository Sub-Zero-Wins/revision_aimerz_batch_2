package com.events.EventsApi.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.events.EventsApi.entities.Booking;
import com.events.EventsApi.entities.BookingStatus;
import com.events.EventsApi.repository.BookingRepository;

public class BookingServiceImpl implements BookingService {

	@Autowired
	BookingRepository repo;

	@Override
	public Booking bookEvent(Booking booking) {
		return repo.save(booking);
	}

	@Override
	public Booking cancelBookedEvent(int bookingId,String status) {
		Booking booking=null;
		try {
			booking = repo.findById(bookingId).orElseThrow(()->new Exception("Booking not found"));
			booking.setBookingStatus(BookingStatus.CANCELLED);
			repo.save(booking);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return booking;
	}

}
