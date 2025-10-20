package com.GeorgeDavidDAM2.festify_apiEdu.services.impl;

import com.GeorgeDavidDAM2.festify_apiEdu.services.ArtistService;
import com.GeorgeDavidDAM2.festify_apiEdu.utils.exception.InvalidIdException;

import ch.qos.logback.classic.Logger;

import com.GeorgeDavidDAM2.festify_apiEdu.dto.request.ArtistResumeRequest;
import com.GeorgeDavidDAM2.festify_apiEdu.dto.response.ArtistDetailResponse;
import com.GeorgeDavidDAM2.festify_apiEdu.dto.response.ArtistResumeResponse;
import com.GeorgeDavidDAM2.festify_apiEdu.mapper.ArtistMapper;
import com.GeorgeDavidDAM2.festify_apiEdu.persistence.jpa.entity.ArtistEntity;
import com.GeorgeDavidDAM2.festify_apiEdu.persistence.jpa.entity.repository.ArtistJpaRepository;

import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistServiceImpl implements ArtistService {

    private Long parseArtistId(String strId) {
    try {
        strId = strId.trim().replace("ART-","");
        Long id = Integer.valueOf(strId).longValue();
        return id;
    }catch (NumberFormatException e) {
        throw new InvalidIdException("Invalid artist id " + strId);
    }
    
}
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

    public ArtistDetailResponse getArtistById(String pubId){
        Long id = parseArtistId(pubId);
        Optional<ArtistEntity> artistEntity = this.artistRepository.findById(id); //findById busca un artista por su id, si no lo encuentra devuelve null
        if(artistEntity.isEmpty()){
            throw new RuntimeException("Artist not found with id: " + id);
        }                                      
        return ArtistMapper.toArtistDetailResponse(artistEntity.get());
    }

    public ArtistResumeResponse createArtist(ArtistResumeRequest artistResumeRequest){
        ArtistEntity artistEntity = new ArtistEntity();
        artistEntity.setName(artistResumeRequest.name());
        artistEntity.setCountry(artistResumeRequest.country());
        artistEntity.setGenres(artistResumeRequest.genres());
        artistEntity.setListeners(artistResumeRequest.listeners());
        artistEntity.setStatus(artistResumeRequest.status());
        artistEntity.setBiography(artistResumeRequest.biography());
        return ArtistMapper.toArtistResumeResponse(this.artistRepository.save(artistEntity)); //repository representa que maneja el acceso a datos, y artistEntity es la entidad que se va a guardar en la base de datos
    }

    public void deleteArtist(String pubId){
        Long id = parseArtistId(pubId);
        if(!this.artistRepository.existsById(id)){
            throw new InvalidIdException("El artista con id " + pubId + " no existe");
        }
        this.artistRepository.deleteById(id);
    }
    
}
