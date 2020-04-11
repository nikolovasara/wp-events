package com.wp.events.repository;

import com.wp.events.model.CoffeeBar;
import com.wp.events.model.Event;

import java.util.List;
import java.util.Optional;

public interface CoffeeBarRepository {
    void saveAll(List<CoffeeBar> coffeeBars);
    CoffeeBar save(CoffeeBar coffeeBar);
    List<CoffeeBar> findAll();
    List<CoffeeBar> searchBars(String term);
    Optional<CoffeeBar> findById(String name);
    void deleteById(String name);
    CoffeeBar getCoffeeBar(String id);
    List<Event> getEventsForCoffeeBar(String id);
}
