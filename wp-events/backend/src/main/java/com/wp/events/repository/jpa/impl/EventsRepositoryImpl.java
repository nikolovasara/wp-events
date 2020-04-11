package com.wp.events.repository.jpa.impl;

import com.wp.events.model.Event;
import com.wp.events.repository.EventsRepository;
import com.wp.events.repository.jpa.JpaEventsRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class EventsRepositoryImpl implements EventsRepository {
    private final JpaEventsRepository repository;

    public EventsRepositoryImpl(JpaEventsRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Event> findById(long id) {
        return this.repository.findById(id);
    }

    @Override
    public Event save(Event event) {
        return this.repository.save(event);
    }
}
