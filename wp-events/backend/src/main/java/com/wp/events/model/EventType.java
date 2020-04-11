package com.wp.events.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum  EventType {
    DAYREL ("Daily relaxing event"),
    LATENIGHT ("Late night event"),
    EARLYHT ("Early night OR evening event");

    private String description;
}
