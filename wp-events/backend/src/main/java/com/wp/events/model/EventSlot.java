package com.wp.events.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@SuppressWarnings("JpaObjectClassSignatureInspection")
@Entity
@Data
public class EventSlot {
    private EventSlot(){}

    @Transient
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private static int slotsCounter = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int slotId;

    @ManyToOne
    private MusicBand musicBand;

    @ManyToOne
    private CoffeeBar coffeeBar;

    @ManyToOne
    private Event event;

    private LocalDate date;
    private LocalTime fromTime;
    private LocalTime toTime;

    public static synchronized EventSlot createEventSlot(Event event, MusicBand musicBand, CoffeeBar coffeeBar, LocalDate date, LocalTime from, LocalTime to){
        EventSlot eventSlot=new EventSlot();
        eventSlot.slotId=slotsCounter;
        slotsCounter++;
        eventSlot.event=event;
        eventSlot.musicBand=musicBand;
        eventSlot.coffeeBar=coffeeBar;
        eventSlot.date=date;
        eventSlot.fromTime=from;
        eventSlot.toTime=to;
        return eventSlot;
    }

}
