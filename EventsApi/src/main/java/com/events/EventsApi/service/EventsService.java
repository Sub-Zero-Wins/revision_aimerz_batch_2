package com.events.EventsApi.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.events.EventsApi.entities.Event;

public interface EventsService 
{
	Event getEventById(int eventId) throws Exception;
	Event addEvent(Event event);
    Event updateEvent(Event event,int eventId);
    boolean deleteEvent(int eventId);
	List<Event> getAllEvents(Pageable pageable);
	Event searchEventByName(String eventName);
    
    
}
