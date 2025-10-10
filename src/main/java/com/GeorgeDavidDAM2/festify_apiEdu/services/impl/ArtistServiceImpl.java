package com.GeorgeDavidDAM2.festify_apiEdu.services.impl;

import com.GeorgeDavidDAM2.festify_apiEdu.services.ArtistService;

import ch.qos.logback.classic.Logger;

import com.GeorgeDavidDAM2.festify_apiEdu.dto.request.ArtistResumeRequest;
import com.GeorgeDavidDAM2.festify_apiEdu.dto.response.ArtistResumeResponse;
import com.GeorgeDavidDAM2.festify_apiEdu.mapper.ArtistMapper;
import com.GeorgeDavidDAM2.festify_apiEdu.persistence.jpa.entity.ArtistEntity;
import com.GeorgeDavidDAM2.festify_apiEdu.persistence.jpa.entity.repository.ArtistJpaRepository;

import java.util.List;

import org.slf4j.LoggerFactory;
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
              .map(ArtistMapper::toArtistResumeResponse) //toArtistResumeResponse es un método estático de la clase ArtistMapper que convierte un ArtistEntity en un ArtistResumeResponse
              .toList();

    }
    public ArtistResumeResponse createArtist(ArtistResumeRequest artistResumeRequest){
        ArtistEntity artistEntity = new ArtistEntity();
        artistEntity.setName(artistResumeRequest.name());
        artistEntity.setCountry(artistResumeRequest.country());
        artistEntity.setGenres(artistResumeRequest.genres());
        artistEntity.setListeners(artistResumeRequest.listeners());
        return ArtistMapper.toArtistResumeResponse(this.artistRepository.save(artistEntity));
    }
}
