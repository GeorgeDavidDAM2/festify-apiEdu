package com.GeorgeDavidDAM2.festify_apiEdu.services.impl;

import com.GeorgeDavidDAM2.festify_apiEdu.services.ArtistService;
import com.GeorgeDavidDAM2.festify_apiEdu.dto.response.ArtistResumeResponse;
import com.GeorgeDavidDAM2.festify_apiEdu.mapper.ArtistMapper;
import com.GeorgeDavidDAM2.festify_apiEdu.persistence.jpa.entity.repository.ArtistJpaRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistServiceImpl implements ArtistService {

    private ArtistJpaRepository artistRepository;
    @Autowired
    public ArtistServiceImpl(ArtistJpaRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public List<ArtistResumeResponse> listArtists() {
       
      return this.artistRepository.findAll().stream()
              .map(ArtistMapper::toArtistResumeResponse)
              .toList();

    }
}
