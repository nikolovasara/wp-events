package com.wp.events.web.rest;

import com.wp.events.model.Event;
import com.wp.events.model.EventSlot;
import com.wp.events.service.EventSlotService;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/events", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
public class EventSlotApi {
    private final EventSlotService eventSlotService;

    public EventSlotApi(EventSlotService eventSlotService) {
        this.eventSlotService = eventSlotService;
    }

    @GetMapping
    public List<EventSlot> getAllEventSlots(@RequestHeader(name = "page", defaultValue = "0", required = false) int page,
                                            @RequestHeader(name = "page-size", defaultValue = "10", required = false) int size) {
        Page<EventSlot> page1= this.eventSlotService.getAllEventSlots(page, size);
        return page1.getContent();
    }

    @GetMapping(params = "term")
    public List<EventSlot> searchEventSlots(@RequestParam String term) {
        return eventSlotService.searchEventSlots(term);
    }

    @PostMapping(path = "/")
    @ResponseStatus(HttpStatus.CREATED)
    public EventSlot createSlot(@RequestParam("eventId") long eventId,
                                @RequestParam("musicBand") String musicBandName,
                                @RequestParam("coffeeBar") String coffeeBarName,
                                @RequestParam("fromTime") @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime from,
                                @RequestParam("toTime") @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime to,
                                @RequestParam("date") String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate formatedDate=LocalDate.parse(date,formatter);
        return eventSlotService.createSlot(eventId, musicBandName, coffeeBarName, formatedDate, from, to);
    }
    @GetMapping("/{slotId}")
    public EventSlot getSlot(@PathVariable int slotId){
        return this.eventSlotService.getEventSlot(slotId);
    }
    @PatchMapping("/{slotId}")
    public EventSlot updateSlot(@PathVariable int slotId,
                                @RequestParam("eventId") long eventId,
                                @RequestParam("musicBand") String musicBandName,
                                @RequestParam("coffeeBar") String coffeeBarName,
                                @RequestParam("fromTime") @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime from,
                                @RequestParam("toTime") @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime to,
                                @RequestParam("date") String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate formatedDate=LocalDate.parse(date,formatter);
        return eventSlotService.updateSlot(slotId, eventId, musicBandName, coffeeBarName, formatedDate, from, to);
    }

    @DeleteMapping("/{slotId}")
    public void deleteSlot(@PathVariable int slotId) {
        eventSlotService.deleteSlot(slotId);
    }
}
