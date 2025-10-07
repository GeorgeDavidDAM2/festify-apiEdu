package com.GeorgeDavidDAM2.festify_apiEdu.mapper;

import com.GeorgeDavidDAM2.festify_apiEdu.dto.response.ArtistResumeResponse;
import com.GeorgeDavidDAM2.festify_apiEdu.persistence.jpa.entity.ArtistEntity;

public class ArtistMapper {

    private static final int DEFAULT_FESTIVALS = 0;
    private static final String DEFAULT_ARTIST_IMG = "https://images.stockcake.com/public/d/c/5/dc531c69-8802-4f3c-a147-0cad55b8c1aa_large/singer-performing-passionately-stockcake.jpg";
    public static ArtistResumeResponse toArtistResumeResponse(ArtistEntity e) {
        return new ArtistResumeResponse(
                e.getId(),
                e.getName(),
                e.getGenres(),
                e.getListeners().intValue(),
                e.getStatus(),
                DEFAULT_FESTIVALS

        );    
                
    }
}

