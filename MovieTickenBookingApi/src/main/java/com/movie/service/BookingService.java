package com.movie.service;

import java.util.List;

import com.movie.entities.Booking;

public interface BookingService 
{
	public Booking makeBooking(Booking booking);
	public List<Booking> getUsersBookings(int userId);
	boolean cancelBooking(int id);
	
	

}
