package com.movie.entities;

import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Booking
{
	@Id
	int bookingid;
	int userId;
	int movieId;
	int numOfSeats;
	LocalTime showTiming;
	double totalPrice;
	String bookingStatus;
	

}
