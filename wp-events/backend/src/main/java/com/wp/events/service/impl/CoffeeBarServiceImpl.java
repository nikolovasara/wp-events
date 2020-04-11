package com.wp.events.service.impl;

import com.wp.events.model.CoffeeBar;
import com.wp.events.model.Event;
import com.wp.events.model.exceptions.InvalidCoffeeBarException;
import com.wp.events.repository.CoffeeBarRepository;
import com.wp.events.service.CoffeeBarService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CoffeeBarServiceImpl implements CoffeeBarService {
    private final CoffeeBarRepository coffeeBarRepository;

    public CoffeeBarServiceImpl(CoffeeBarRepository coffeeBarRepository) {
        this.coffeeBarRepository = coffeeBarRepository;
    }

    @Override
    public CoffeeBar createCoffeeBar(String name, String city) {
        CoffeeBar coffeeBar=new CoffeeBar(name,city,new ArrayList<>());
        return this.coffeeBarRepository.save(coffeeBar);
    }

    @Override
    public List<CoffeeBar> getAllCoffeeBars() {
        return this.coffeeBarRepository.findAll();
    }

    @Override
    public List<CoffeeBar> searchCoffeeBars(String term) {
        return this.coffeeBarRepository.searchBars(term);
    }

    @Override
    public CoffeeBar updateCoffeeBar(String id, String name, String city) {
        CoffeeBar coffeeBar=this.coffeeBarRepository.getCoffeeBar(id);
        coffeeBar.setName(name);
        coffeeBar.setCity(city);
        return this.coffeeBarRepository.save(coffeeBar);
    }

    @Override
    public void deleteCoffeeBar(String name) {
        this.coffeeBarRepository.deleteById(name);

    }

    @Override
    public Optional<CoffeeBar> findByName(String name) {
        return this.coffeeBarRepository.findById(name);
    }

    @Override
    public List<Event> getEventsForCoffeeBar(String name) {
        return this.coffeeBarRepository.getEventsForCoffeeBar(name);
    }

    @Override
    public CoffeeBar getCoffeeBar(String id) {
        return this.coffeeBarRepository.getCoffeeBar(id);
    }
}
