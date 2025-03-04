package com.events.EventsApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.events.EventsApi.entities.Event;

public interface EventsRepository extends JpaRepository<Event,Integer>
{
   Event findByEventName(String eventName);
}
