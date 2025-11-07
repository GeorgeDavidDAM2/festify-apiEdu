package com.GeorgeDavidDAM2.festify_apiEdu.mapper;

import com.GeorgeDavidDAM2.festify_apiEdu.dto.response.ArtistDetailResponse;
import com.GeorgeDavidDAM2.festify_apiEdu.dto.response.ArtistResumeResponse;
import com.GeorgeDavidDAM2.festify_apiEdu.persistence.jpa.entity.ArtistEntity;

public class ArtistMapper { //CONVIERTE datos entre diferentes formatos.

   
    public static ArtistResumeResponse toArtistResumeResponse(ArtistEntity e) {
        return new ArtistResumeResponse(
                "ART-"+e.getId(),
                e.getName(),
                e.getCountry(),
                e.getGenres(),
                e.getListeners(),
                e.getStatus()
                );
    }
    public static ArtistDetailResponse toArtistDetailResponse(ArtistEntity e) {
        return new ArtistDetailResponse(
                "ART-"+e.getId(),
                e.getName(),
                e.getGenres(),
                e.getCountry(),
                e.getListeners(),
                e.getStatus(),
                e.getBiography()
                );
    }
}

