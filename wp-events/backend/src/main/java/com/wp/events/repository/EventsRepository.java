package com.wp.events.repository;

import com.wp.events.model.Event;

import java.util.Optional;

public interface EventsRepository {
    Optional<Event> findById(long id);
    Event save(Event event);
}
