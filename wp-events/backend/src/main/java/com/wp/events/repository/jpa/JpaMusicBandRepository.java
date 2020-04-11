package com.wp.events.repository.jpa;

import com.wp.events.model.MusicBand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaMusicBandRepository extends JpaRepository<MusicBand,String> {
}
