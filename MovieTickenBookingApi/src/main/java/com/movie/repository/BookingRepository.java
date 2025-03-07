package com.movie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie.entities.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> 
{

	List<Booking> findByUserId(int userId);


}



