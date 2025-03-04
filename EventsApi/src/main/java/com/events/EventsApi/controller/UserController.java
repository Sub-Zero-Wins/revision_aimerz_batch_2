package com.events.EventsApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.events.EventsApi.entities.Booking;
import com.events.EventsApi.entities.BookingStatus;
import com.events.EventsApi.entities.Event;
import com.events.EventsApi.service.BookingService;
import com.events.EventsApi.service.EventsService;

@RestController
@RequestMapping("/events/user")
public class UserController 
{

	@Autowired
	EventsService service;
	
	@Autowired
	BookingService bookingService;
	
	@GetMapping("/all")
	public List<Event> getAllEvents(@RequestParam(defaultValue="0") int page,
			@RequestParam(defaultValue="5") int size,
			@RequestParam(defaultValue="price") String sortBy,
			@RequestParam(defaultValue="true") boolean ascending) {

		Sort sort = ascending ? Sort.by(sortBy).ascending() :  Sort.by(sortBy).descending();
		Pageable pageable = PageRequest.of(page, size,sort);
		return  service.getAllEvents(pageable);
	}


	@GetMapping("/{eventId}")
	public Event getEventById(@PathVariable int eventId) throws Exception {

		return service.getEventById(eventId);
	}


    @GetMapping("/search")
	public Event searchEventByName(@RequestParam String eventName) {

		return service.searchEventByName(eventName);
	}
    
    @PostMapping("/book")
    public Booking bookEvent(@RequestBody Booking booking)
    {
    	return bookingService.bookEvent(booking);
    }
    
    @GetMapping("/cancel/{bookingId}")
    public Booking cancelBookedEvent(@PathVariable int bookingId)
    {
    	return bookingService.cancelBookedEvent(bookingId, "CANCELLED");
    }
    


}
