package com.GeorgeDavidDAM2.festify_apiEdu.mapper;

import com.GeorgeDavidDAM2.festify_apiEdu.dto.response.AlbumResponse;
import com.GeorgeDavidDAM2.festify_apiEdu.persistence.jpa.entity.AlbumEntity;

public class AlbumMapper {
    public static AlbumResponse toAlbumResponse(AlbumEntity album) {
        return new AlbumResponse(
            album.getId(),
            album.getTitle(),
            album.getArtistId(),
            album.getReleaseDate(),
            album.getTracksCount(),
            album.getDurationSeconds()
        );
    }
}
