package com.wp.events.repository.jpa.impl;

import com.wp.events.model.MusicBand;
import com.wp.events.model.exceptions.InvalidMusicBandException;
import com.wp.events.repository.MusicBandRepository;
import com.wp.events.repository.jpa.JpaMusicBandRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class MusicBandRepositoryImpl implements MusicBandRepository {
    private final JpaMusicBandRepository repository;

    public MusicBandRepositoryImpl(JpaMusicBandRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<MusicBand> findById(String name) {
        return this.repository.findById(name);
    }

    @Override
    public void save(MusicBand musicBand) {
        this.repository.save(musicBand);
    }
}
