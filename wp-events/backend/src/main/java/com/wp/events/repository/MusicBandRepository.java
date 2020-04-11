package com.wp.events.repository;

import com.wp.events.model.MusicBand;

import java.util.Optional;

public interface MusicBandRepository {
    Optional<MusicBand> findById(String name);
    void save(MusicBand musicBand);
}
