package com.events.EventsApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.events.EventsApi.entities.Event;
import com.events.EventsApi.repository.EventsRepository;

@Service
public class EventsServiceImpl implements EventsService {

	@Autowired
	EventsRepository repo;

	@Override
	public List<Event> getAllEvents(Pageable pageable) {

		return repo.findAll(pageable).toList();
	}

	@Override
	public Event getEventById(int eventId) throws Exception {

		return repo.findById(eventId).orElseThrow(()->new Exception("event Not found with givenId"));
	}

	@Override
	public Event addEvent(Event event) {

		return repo.save(event);
	}

	@Override
	public Event updateEvent(Event event, int eventId) {
		try {
			if(getEventById(eventId)!=null)
				return repo.save(event);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean deleteEvent(int eventId) {
		try {
			if(getEventById(eventId)!=null) {
				repo.deleteById(eventId);
				return true;		
		} 
		}
			catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Event searchEventByName(String eventName) {
		
		return repo.findByEventName(eventName);
	}

}
