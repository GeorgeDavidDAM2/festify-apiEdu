package com.GeorgeDavidDAM2.festify_apiEdu.services.impl;

import com.GeorgeDavidDAM2.festify_apiEdu.services.ArtistService;
import com.GeorgeDavidDAM2.festify_apiEdu.utils.exception.ArtistNotFoundException;
import com.GeorgeDavidDAM2.festify_apiEdu.utils.exception.InvalidIdException;


import com.GeorgeDavidDAM2.festify_apiEdu.dto.request.ArtistResumeRequest;
import com.GeorgeDavidDAM2.festify_apiEdu.dto.response.ArtistDetailResponse;
import com.GeorgeDavidDAM2.festify_apiEdu.dto.response.ArtistResumeResponse;
import com.GeorgeDavidDAM2.festify_apiEdu.mapper.ArtistMapper;
import com.GeorgeDavidDAM2.festify_apiEdu.persistence.jpa.entity.ArtistEntity;
import com.GeorgeDavidDAM2.festify_apiEdu.persistence.jpa.entity.repository.ArtistJpaRepository;

import java.util.List;
import java.util.Optional;

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
    private ArtistJpaRepository artistRepository;//Declaramoos la dependencia del repositorio
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
    /*return this.artistRepository.findAll().stream()
              .map(artist -> ArtistMapper.toArtistResumeResponse(artist)) Por cada artista que encuentre en el repositorio lo mapea a un ArtistResumeResponse
              .toList();
    } */

    public ArtistDetailResponse getArtistById(String pubId){
        Long id = parseArtistId(pubId);
        Optional<ArtistEntity> artistEntity = this.artistRepository.findById(id); //findById busca un artista por su id, si no lo encuentra devuelve null
        if(artistEntity.isEmpty()){
            throw new RuntimeException("Artist not found with id: " + id);
        }                                      
        return ArtistMapper.toArtistDetailResponse(artistEntity.get());
    }

    public ArtistResumeResponse createArtist(ArtistResumeRequest artistResumeRequest){
        ArtistEntity artistEntity = new ArtistEntity(); //Creamos una nueva entidad de artista
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
            throw new ArtistNotFoundException("El artista con id " + pubId + " no existe");
        }
        this.artistRepository.deleteById(id);
    }

    public ArtistDetailResponse updateArtist(String pubId, ArtistResumeRequest artistResumeRequest){
        Long id = parseArtistId(pubId);
        Optional<ArtistEntity> artistEntityOptional = this.artistRepository.findById(id); //el optional se usa para evitar el null pointer exception, en el create no hace falta porque se crea uno nuevo
        if(artistEntityOptional.isEmpty()){
            throw new ArtistNotFoundException("El artista con id " + pubId + " no existe");
        }
        ArtistEntity artistEntity = artistEntityOptional.get(); //pasamos de optional a entity para poder modificarlo
        artistEntity.setName(artistResumeRequest.name());
        artistEntity.setCountry(artistResumeRequest.country());
        artistEntity.setGenres(artistResumeRequest.genres());
        artistEntity.setListeners(artistResumeRequest.listeners());
        artistEntity.setStatus(artistResumeRequest.status());
        artistEntity.setBiography(artistResumeRequest.biography());
        return ArtistMapper.toArtistDetailResponse(this.artistRepository.save(artistEntity));
    }

    
    
    
}
