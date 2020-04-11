package com.wp.events.repository.jpa.impl;

import com.wp.events.model.EventSlot;
import com.wp.events.repository.EventSlotRepository;
import com.wp.events.repository.jpa.JpaEventSlotRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EventSlotRepositoryImpl implements EventSlotRepository {
    private final JpaEventSlotRepository repository;

    public EventSlotRepositoryImpl(JpaEventSlotRepository repository) {
        this.repository = repository;
    }

    @Override
    public EventSlot save(EventSlot slot) {
        return this.repository.save(slot);
    }

    @Override
    public Page<EventSlot> getAllEventSlots(int page, int size) {
        return this.repository.findAll(PageRequest.of(page,size));
    }

    @Override
    public List<EventSlot> searchEventSlots(String term) {
        return this.repository.searchEventSlots(term);
    }

    @Override
    public Optional<EventSlot> findById(int slotId) {
        return this.repository.findById(slotId);
    }

    @Override
    public void deleteById(int slotId) {
        this.repository.deleteById(slotId);
    }
}
