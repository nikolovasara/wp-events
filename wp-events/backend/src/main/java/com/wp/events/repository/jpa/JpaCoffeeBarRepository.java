package com.wp.events.repository.jpa;

import com.wp.events.model.CoffeeBar;
import com.wp.events.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JpaCoffeeBarRepository extends JpaRepository<CoffeeBar,String> {
    @Query("select c from CoffeeBar c " +
            "where c.name like :term")
    List<CoffeeBar> searchCoffeeBars(@Param("term") String term);

    @Query("select e from Event e join e.coffeeBars cb where cb.id=:id")
    List<Event> getEventsForCoffeeBar(@Param("id") String id);
}
