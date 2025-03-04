package com.events.EventsApi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Event 
{
	@Id
	private int eventId;
	private String eventName;
	private String eventDescription;
	private String eventDate;
	private double ticketPrice;
	private int availableSeats;
	
	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getEventDescription() {
		return eventDescription;
	}
	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}
	public String getEventDate() {
		return eventDate;
	}
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}
	public double getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	
	public Event(int eventId, String eventName, String eventDescription, String eventDate, double ticketPrice,
			int availableSeats) {
		super();
		this.eventId = eventId;
		this.eventName = eventName;
		this.eventDescription = eventDescription;
		this.eventDate = eventDate;
		this.ticketPrice = ticketPrice;
		this.availableSeats = availableSeats;
	}
	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
