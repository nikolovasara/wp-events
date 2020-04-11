package com.wp.events.repository.jpa;

import com.wp.events.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaEventsRepository extends JpaRepository<Event,Long> {
}
