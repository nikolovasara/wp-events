package com.wp.events.bootstrap;

import com.wp.events.model.*;
import com.wp.events.repository.jpa.JpaCoffeeBarRepository;
import com.wp.events.repository.jpa.JpaEventSlotRepository;
import com.wp.events.repository.jpa.JpaEventsRepository;
import com.wp.events.repository.jpa.JpaMusicBandRepository;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class DataHolder {

    public static final List<Event> events = new ArrayList<>();

    public static final List<MusicBand> musicBands = new ArrayList<>();

    public static final List<CoffeeBar> coffeeBars = new ArrayList<>();

    public static final List<EventSlot> slots = new ArrayList<>();

    public final JpaEventsRepository eventsRepository;

    public final JpaMusicBandRepository musicBandRepository;

    public final JpaCoffeeBarRepository coffeeBarRepository;

    public final JpaEventSlotRepository eventSlotRepository;

    public DataHolder(JpaEventsRepository eventsRepository, JpaMusicBandRepository musicBandRepository, JpaCoffeeBarRepository coffeeBarRepository, JpaEventSlotRepository eventSlotRepository) {
        this.eventsRepository = eventsRepository;
        this.musicBandRepository = musicBandRepository;
        this.coffeeBarRepository = coffeeBarRepository;
        this.eventSlotRepository = eventSlotRepository;
    }

    @PostConstruct
    public void init() {
        musicBands.add(new MusicBand("Eye Cue", MusicType.POP, "Skopje"));
        musicBands.add(new MusicBand("Vizija", MusicType.ROCK, "Skopje"));
        musicBands.add(new MusicBand("Filch", MusicType.JAZZ, "Skopje"));
        musicBands.add(new MusicBand("Armadillo", MusicType.ROCK, "Skopje"));
        musicBands.add(new MusicBand("Lithium", MusicType.ROCKnROLL, "M.Kamenica"));
        musicBands.add(new MusicBand("Melissa", MusicType.METAL, "Kicevo"));
        musicBands.add(new MusicBand("Verka", MusicType.ETHNO, "Delcevo"));
        musicBands.add(new MusicBand("HaHaHa", MusicType.PUNK, "Skopje"));


        coffeeBars.add(new CoffeeBar("Gallery","Skopje",new ArrayList<>()));
        coffeeBars.add(new CoffeeBar("Revija","Skopje",new ArrayList<>()));
        coffeeBars.add(new CoffeeBar("Roosevelt","Skopje",new ArrayList<>()));
        coffeeBars.add(new CoffeeBar("Square","Stip",new ArrayList<>()));
        coffeeBars.add(new CoffeeBar("Apolon","Delcevo",new ArrayList<>()));
        coffeeBars.add(new CoffeeBar("Fenix","Sveti Nikole",new ArrayList<>()));
        coffeeBars.add(new CoffeeBar("Broz","Skopje",new ArrayList<>()));
        coffeeBars.add(new CoffeeBar("Plaza","Sveti Nikole",new ArrayList<>()));
        coffeeBars.add(new CoffeeBar("Plan B","Veles",new ArrayList<>()));
        coffeeBars.add(new CoffeeBar("Angels","Stip",new ArrayList<>()));

        Event dayrel=new Event("Enjoy the Afternoon",EventType.DAYREL,new ArrayList<>());
        Event latenight=new Event("Memorable Night with Your Company",EventType.LATENIGHT,new ArrayList<>());
        Event earlyht=new Event("Warm Up for the Night",EventType.EARLYHT,new ArrayList<>());

        events.add(dayrel);
        events.add(latenight);
        events.add(earlyht);

        coffeeBars.get(0).addEvent(dayrel);
        coffeeBars.get(0).addEvent(earlyht);
        coffeeBars.get(1).addEvent(latenight);
        coffeeBars.get(2).addEvent(latenight);
        coffeeBars.get(2).addEvent(dayrel);
        coffeeBars.get(3).addEvent(earlyht);
        coffeeBars.get(4).addEvent(dayrel);
        coffeeBars.get(4).addEvent(earlyht);
        coffeeBars.get(5).addEvent(latenight);
        coffeeBars.get(5).addEvent(dayrel);
        coffeeBars.get(6).addEvent(dayrel);
        coffeeBars.get(7).addEvent(latenight);
        coffeeBars.get(8).addEvent(latenight);
        coffeeBars.get(8).addEvent(dayrel);
        coffeeBars.get(9).addEvent(earlyht);


        slots.add(EventSlot.createEventSlot(dayrel,musicBands.get(1),coffeeBars.get(0), LocalDate.now().plusDays(7),LocalTime.parse("14:00"),LocalTime.parse("17:00")));
        slots.add(EventSlot.createEventSlot(latenight,musicBands.get(2),coffeeBars.get(2),LocalDate.now().plusDays(10),LocalTime.parse("22:00"),LocalTime.parse("01:00")));
        slots.add(EventSlot.createEventSlot(latenight,musicBands.get(0),coffeeBars.get(5),LocalDate.now().plusDays(8),LocalTime.parse("23:00"),LocalTime.parse("01:00")));
        slots.add(EventSlot.createEventSlot(latenight,musicBands.get(2),coffeeBars.get(2),LocalDate.now().plusDays(10),LocalTime.parse("22:00"),LocalTime.parse("01:00")));
        slots.add(EventSlot.createEventSlot(earlyht,musicBands.get(3),coffeeBars.get(9),LocalDate.now().plusDays(9),LocalTime.parse("19:00"),LocalTime.parse("21:00")));

        if(this.eventSlotRepository.count()==0){
            this.musicBandRepository.saveAll(musicBands);
            this.coffeeBarRepository.saveAll(coffeeBars);
            this.eventsRepository.saveAll(events);
            this.eventSlotRepository.saveAll(slots);
        }

    }

}
