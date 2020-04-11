package com.wp.events.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MusicBand {
    @Id
    private String name;

    @Enumerated(EnumType.STRING)
    private MusicType musicType;
    private String city;

}
