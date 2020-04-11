package com.wp.events.web.rest;


import com.wp.events.model.CoffeeBar;
import com.wp.events.model.Event;
import com.wp.events.model.exceptions.InvalidCoffeeBarException;
import com.wp.events.service.CoffeeBarService;
import org.springframework.http.HttpStatus;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/coffeeBars")
public class CoffeeBarApi {
    private final CoffeeBarService coffeeBarService;

    public CoffeeBarApi(CoffeeBarService coffeeBarService) {
        this.coffeeBarService = coffeeBarService;
    }

    @GetMapping
    public List<CoffeeBar> getAllCoffeeBars() {
        return coffeeBarService.getAllCoffeeBars();
    }

    @GetMapping(params = "term")
    public List<CoffeeBar> searchCoffeeBars(@RequestParam String term) {
        return coffeeBarService.searchCoffeeBars(term);
    }

    @PostMapping(path = "/")
    @ResponseStatus(HttpStatus.CREATED)
    public CoffeeBar createCoffeeBar(@RequestParam("name") String name,
                                     @RequestParam("city") String city) {
        return this.coffeeBarService.createCoffeeBar(name, city);
    }

    @GetMapping("/{id}")
    public CoffeeBar getCoffeeBar(@PathVariable String id) {
        return this.coffeeBarService.getCoffeeBar(id);
    }

    @PatchMapping("/{id}")
    public CoffeeBar updateCoffeeBar(@PathVariable String id,
                                     @RequestParam String name,
                                     @RequestParam String city) {
        return this.coffeeBarService.updateCoffeeBar(id, name, city);
    }

    @DeleteMapping("/{id}")
    public void deleteSlot(@PathVariable String id) {
        this.coffeeBarService.deleteCoffeeBar(id);
    }


    @GetMapping(path = "/{id}/events")
    public List<Event> getEventsForCoffeeBar(@PathVariable String id) {
        return this.coffeeBarService.getEventsForCoffeeBar(id);
    }
}
