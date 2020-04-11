package com.wp.events.service;

import com.wp.events.model.CoffeeBar;
import com.wp.events.model.Event;

import java.util.List;
import java.util.Optional;

public interface CoffeeBarService {
    CoffeeBar createCoffeeBar(String name, String city);

    List<CoffeeBar> getAllCoffeeBars();

    List<CoffeeBar> searchCoffeeBars(String term);

    CoffeeBar updateCoffeeBar(String id, String name, String city);

    void deleteCoffeeBar(String name);

    Optional<CoffeeBar> findByName(String name);

    List<Event> getEventsForCoffeeBar(String name);

    CoffeeBar getCoffeeBar(String id);
}
