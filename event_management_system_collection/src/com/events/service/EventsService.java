package com.events.service;

import java.util.List;

import com.events.entity.Event;

public interface EventsService {

	boolean addEvent(Event event);
	List<Event> getAllEvents();
	boolean deleteEvent(String eventId);
	Event getEventById(String eventId);
	Event updateEvent(Event newEvent);
	String registerForEvent(String eventId);
}
