package com.GeorgeDavidDAM2.festify_apiEdu.services.impl;


import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GeorgeDavidDAM2.festify_apiEdu.dto.response.AlbumResponse;

import com.GeorgeDavidDAM2.festify_apiEdu.mapper.AlbumMapper;
import com.GeorgeDavidDAM2.festify_apiEdu.persistence.jpa.entity.AlbumEntity;
import com.GeorgeDavidDAM2.festify_apiEdu.persistence.jpa.entity.AlbumJpaRepository;
import com.GeorgeDavidDAM2.festify_apiEdu.services.AlbumService;

@Service
public class AlbumServiceImpl implements AlbumService {

    private static final Logger logger = Logger.getLogger(AlbumServiceImpl.class.getName());
    
    private AlbumJpaRepository albumRepository;//Declaramos la dependencia del repositorio
    @Autowired
    public AlbumServiceImpl(AlbumJpaRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public List<AlbumResponse> listAlbums(Long artistId) {
    logger.info("Listing albums for artist ID: " + artistId);
    List<AlbumEntity> albums = this.albumRepository.findByArtistId(artistId);
    logger.info("Found " + albums.size() + " albums for artist ID: " + artistId);
      return albums.stream()
              .map(AlbumMapper::toAlbumResponse) //toAAlbumResponse es un método estático de la clase AlbumMapper que convierte un AlbumEntity en un AAlbumResponse
              .toList();
    }
    
}
