package com.events.repository;

import java.util.ArrayList;
import java.util.List;

import com.events.entity.Event;

public class EventsDAOImpl implements EventsDAO {
	
	private static List<Event> events;
	
	private int eventCount;
	
	public EventsDAOImpl(int capacity)
	{
		this.events=new ArrayList<Event>();
		this.eventCount=0;
	}

	@Override
	public boolean addEvent(Event event) {
		
		
		 if(eventCount>events.size())
		{
			return false;
		}
		else
		{
			events.add(event);
			eventCount++;
		}
		
		return true;
	}

	@Override
	public List<Event> getAllEvents() {
		
		
		if(events.size()<=0) {
			return null;
		}
		else
		 return events;
	}

	@Override
	public boolean deleteEvent(String eventId) {
		
		for(int i=0; i< events.size(); i++)
		{
			if(events.get(i).getEventId().equals(eventId))
			{
				events.remove(i);
				return true;
			}
		}
		return false;
	}

	@Override
	public Event getEventById(String eventId) {
		Event res = null;
		for(int i =0 ;i < events.size() ; i++)
		{
			if(events.get(i).getEventId().equals(eventId))
			{
				res=events.get(i);
			}
		}
		return res;
	}

	@Override
	public Event updateEvent(Event newEvent) {
		Event res = null;
		for(int i =0 ;i < events.size() ; i++)
		{
			if(events.get(i).getEventId().equals(newEvent.getEventId()))
			{
				events.set(i, newEvent);
				res=newEvent;
			}
		}
		return res;
	}

}
