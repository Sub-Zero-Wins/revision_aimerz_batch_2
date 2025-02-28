package com.events.controller;

import com.events.repository.EventsDAO;
import com.events.repository.EventsDAOImpl;
import com.events.service.EventsService;
import com.events.service.EventsServiceImpl;

public class EventManagementSystem {

public static void main(String[] args) {
		
		EventsDAO dao = new EventsDAOImpl(10);
		EventsService service = new EventsServiceImpl(dao);
		EventsController controller = new EventsController(service);
		
		controller.start();
		
	}

}
