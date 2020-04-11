package com.wp.events.service;


import com.wp.events.model.EventSlot;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface EventSlotService {

    EventSlot createSlot(long eventId, String musicBandName, String coffeeBarName, LocalDate date, LocalTime from, LocalTime to);

    Page<EventSlot> getAllEventSlots(int page, int size);

    List<EventSlot> searchEventSlots(String term);

    EventSlot getEventSlot(int slotId);

    EventSlot updateSlot(int slotId, long eventId, String musicBandName, String coffeeBarName, LocalDate date, LocalTime from, LocalTime to);

    void deleteSlot(int slotId);

}
