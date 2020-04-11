package com.wp.events.repository.jpa.impl;

import com.wp.events.model.CoffeeBar;
import com.wp.events.model.Event;
import com.wp.events.model.exceptions.InvalidCoffeeBarException;
import com.wp.events.repository.CoffeeBarRepository;
import com.wp.events.repository.jpa.JpaCoffeeBarRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CoffeeBarRepositoryImpl implements CoffeeBarRepository {
    private final JpaCoffeeBarRepository repository;

    public CoffeeBarRepositoryImpl(JpaCoffeeBarRepository repository) {
        this.repository = repository;
    }

    @Override
    public void saveAll(List<CoffeeBar> coffeeBars) {
        this.repository.saveAll(coffeeBars);
    }

    @Override
    public CoffeeBar save(CoffeeBar coffeeBar) {
        return this.repository.save(coffeeBar);
    }

    @Override
    public List<CoffeeBar> findAll() {
        return this.repository.findAll();
    }

    @Override
    public List<CoffeeBar> searchBars(String term) {
        return this.repository.searchCoffeeBars(term);
    }

    @Override
    public Optional<CoffeeBar> findById(String id) {
        return this.repository.findById(id);
    }

    @Override
    public void deleteById(String id) {
        this.repository.deleteById(id);
    }

    @Override
    public CoffeeBar getCoffeeBar(String id) {
        return this.repository.findById(id).orElseThrow(InvalidCoffeeBarException::new);
    }

    @Override
    public List<Event> getEventsForCoffeeBar(String id) {
        return this.repository.getEventsForCoffeeBar(id);
    }
}
