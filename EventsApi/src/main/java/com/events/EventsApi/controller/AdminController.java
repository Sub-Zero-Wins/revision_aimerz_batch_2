package com.events.EventsApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.events.EventsApi.entities.Event;
import com.events.EventsApi.service.EventsService;

@RestController
@RequestMapping("/events/admin")
public class AdminController
{
	@Autowired
	EventsService service;
	
	
	@PostMapping("/add")
	public Event addEvent(@RequestBody Event event) {

		return service.addEvent(event);
	}

	@PutMapping("/update/{eventId}")
	public Event updateEvent(@RequestBody Event event, @PathVariable int eventId) {
		return service.updateEvent(event, eventId);
	}

	@DeleteMapping("/delete/{eventId}")
	public boolean deleteEvent(@PathVariable int eventId) {
		return service.deleteEvent(eventId);
	}

   
}
