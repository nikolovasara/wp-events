package com.wp.events.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private EventType eventType;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<CoffeeBar> coffeeBars;

    public Event(String name, EventType type,List<CoffeeBar> coffeeBars) {
        this.name=name;
        this.eventType=type;
        this.coffeeBars=coffeeBars;
    }

    public void addCoffeeBar(CoffeeBar coffeeBar){
        this.coffeeBars.add(coffeeBar);
        coffeeBar.getEvents().add(this);
    }
}
