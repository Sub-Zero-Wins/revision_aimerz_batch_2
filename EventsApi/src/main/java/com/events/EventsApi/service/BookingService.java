package com.events.EventsApi.service;

import com.events.EventsApi.entities.Booking;

public interface BookingService 
{
	Booking bookEvent(Booking booking);

	Booking cancelBookedEvent(int bookingId, String status);
	
	
	

}
