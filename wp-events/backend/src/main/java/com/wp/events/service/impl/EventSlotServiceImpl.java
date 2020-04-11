package com.wp.events.service.impl;


import com.wp.events.model.CoffeeBar;
import com.wp.events.model.Event;
import com.wp.events.model.EventSlot;
import com.wp.events.model.MusicBand;
import com.wp.events.model.exceptions.InvalidCoffeeBarException;
import com.wp.events.model.exceptions.InvalidEventNameException;
import com.wp.events.model.exceptions.InvalidEventSlotException;
import com.wp.events.model.exceptions.InvalidMusicBandException;
import com.wp.events.repository.CoffeeBarRepository;
import com.wp.events.repository.EventSlotRepository;
import com.wp.events.repository.EventsRepository;
import com.wp.events.repository.MusicBandRepository;
import com.wp.events.service.EventSlotService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class EventSlotServiceImpl implements EventSlotService {
    private final EventSlotRepository eventSlotRepository;
    private final EventsRepository eventsRepository;
    private final MusicBandRepository musicBandRepository;
    private final CoffeeBarRepository coffeeBarRepository;

    public EventSlotServiceImpl(EventSlotRepository eventSlotRepository, EventsRepository eventsRepository, MusicBandRepository musicBandRepository, CoffeeBarRepository coffeeBarRepository) {
        this.eventSlotRepository = eventSlotRepository;
        this.eventsRepository = eventsRepository;
        this.musicBandRepository = musicBandRepository;
        this.coffeeBarRepository = coffeeBarRepository;
    }

    @Override
    public EventSlot createSlot(long eventId, String musicBandName, String coffeeBarName, LocalDate date, LocalTime from, LocalTime to) {
        EventSlot eventSlot;
        Event event=this.eventsRepository.findById(eventId).orElseThrow(InvalidEventNameException::new);
        MusicBand musicBand=this.musicBandRepository.findById(musicBandName).orElseThrow(InvalidMusicBandException::new);
        CoffeeBar coffeeBar=this.coffeeBarRepository.findById(coffeeBarName).orElseThrow(InvalidCoffeeBarException::new);
        eventSlot=EventSlot.createEventSlot(event,musicBand,coffeeBar,date,from,to);
        return this.eventSlotRepository.save(eventSlot);

    }

    @Override
    public Page<EventSlot> getAllEventSlots(int page, int size) {
        return this.eventSlotRepository.getAllEventSlots(page,size);
    }

    @Override
    public List<EventSlot> searchEventSlots(String term) {
        return this.eventSlotRepository.searchEventSlots(term);
    }

    @Override
    public EventSlot getEventSlot(int slotId) {
        return this.eventSlotRepository.findById(slotId).orElseThrow(InvalidEventSlotException::new);
    }

    @Override
    public EventSlot updateSlot(int slotId, long eventId, String musicBandName, String coffeeBarName, LocalDate date, LocalTime from, LocalTime to) {
        EventSlot slot=this.eventSlotRepository.findById(slotId).orElseThrow(InvalidEventSlotException::new);
        Event event=this.eventsRepository.findById(eventId).orElseThrow(InvalidEventNameException::new);
        MusicBand musicBand=this.musicBandRepository.findById(musicBandName).orElseThrow(InvalidMusicBandException::new);
        CoffeeBar coffeeBar=this.coffeeBarRepository.findById(coffeeBarName).orElseThrow(InvalidCoffeeBarException::new);
        slot.setEvent(event);
        slot.setMusicBand(musicBand);
        slot.setCoffeeBar(coffeeBar);
        slot.setDate(date);
        slot.setToTime(to);
        slot.setFromTime(from);
        return this.eventSlotRepository.save(slot);
    }

    @Override
    public void deleteSlot(int slotId) {
        this.eventSlotRepository.deleteById(slotId);
    }
}
