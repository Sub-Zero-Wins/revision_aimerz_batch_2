package com.events.EventsApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.events.EventsApi.entities.Booking;

public interface BookingRepository extends JpaRepository<Booking,Integer> {

}
