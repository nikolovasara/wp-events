package com.wp.events.repository.jpa;

import com.wp.events.model.EventSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JpaEventSlotRepository extends JpaRepository<EventSlot,Integer> {
    @Query("select e from EventSlot e " +
            "where e.event.name like :term")
    List<EventSlot> searchEventSlots(@Param("term") String term);
}
