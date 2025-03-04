package com.events.EventsApi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

@Entity
public class Booking 
{
	@Id
	private int bookingId;
	private int userId;
	private int eventId;
	private int numOfSeats;
	private double totalPrice;
	@Enumerated(EnumType.STRING)
	private BookingStatus bookingStatus;
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public int getNumOfSeats() {
		return numOfSeats;
	}
	public void setNumOfSeats(int numOfSeats) {
		this.numOfSeats = numOfSeats;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public BookingStatus getBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(BookingStatus bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	public Booking(int bookingId, int userId, int eventId, int numOfSeats, double totalPrice,
			BookingStatus bookingStatus) {
		super();
		this.bookingId = bookingId;
		this.userId = userId;
		this.eventId = eventId;
		this.numOfSeats = numOfSeats;
		this.totalPrice = totalPrice;
		this.bookingStatus = bookingStatus;
	}
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
