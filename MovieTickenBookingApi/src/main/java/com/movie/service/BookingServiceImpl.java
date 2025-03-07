package com.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.movie.entities.Booking;
import com.movie.repository.BookingRepository;

public class BookingServiceImpl implements BookingService {
	
	@Autowired
	BookingRepository bookingRepo;

	@Override
	public Booking makeBooking(Booking booking) {
		return bookingRepo.save(booking);
	}

	@Override
	public boolean cancelBooking(int id) {
		
		
		boolean res= false;
		Booking bookingUpdate=bookingRepo.findById(id).get();
		if(bookingUpdate!=null)
		{
			bookingUpdate.setBookingStatus("CANCELLED");
			bookingRepo.save(bookingUpdate);
					
			res=true;
		}
		
		return res;
	
	}

	@Override
	public List<Booking> getUsersBookings(int userId) {
		return 	bookingRepo.findByUserId(userId);
		
	}

}
