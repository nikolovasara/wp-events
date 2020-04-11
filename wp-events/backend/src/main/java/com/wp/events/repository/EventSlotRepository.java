package com.wp.events.repository;

import com.wp.events.model.EventSlot;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface EventSlotRepository {
    EventSlot save(EventSlot slot);
    Page<EventSlot> getAllEventSlots(int page, int size);
    List<EventSlot> searchEventSlots(String term);
    Optional<EventSlot> findById(int slotId);
    void deleteById(int slotId);
}
