package com.wp.events.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class CoffeeBar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String name;

    private String city;

    @NotFound(action= NotFoundAction.IGNORE)
    @ManyToMany(mappedBy = "coffeeBars",fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Event> events;

    public CoffeeBar(String name, String city, List<Event> events) {
        this.name=name;
        this.city=city;
        this.events=events;
    }

    public void addEvent(Event e){
        if(this.events==null){
            this.events=new ArrayList<>();
        }
        this.events.add(e);
        if(e.getCoffeeBars()==null){
            e.setCoffeeBars(new ArrayList<>());
        }
        e.getCoffeeBars().add(this);
    }
}
