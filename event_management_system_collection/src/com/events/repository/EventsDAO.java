package com.events.repository;

import java.util.List;

import com.events.entity.Event;

public interface EventsDAO
{
	boolean addEvent(Event event);
	List<Event> getAllEvents();
	boolean deleteEvent(String eventId);
	Event getEventById(String eventId);
	Event updateEvent(Event newEvent);

}
