package com.GeorgeDavidDAM2.festify_apiEdu.dto.response;

import java.sql.Date;

public record AlbumResponse(
    Long id,
    String title,
    Long artistId,
    Date releaseDate,
    Integer tracksCount,
    Integer durationSeconds
    ) {
}
