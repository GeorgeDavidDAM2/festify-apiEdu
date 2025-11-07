package com.GeorgeDavidDAM2.festify_apiEdu.dto.request;

import java.sql.Date;

public record AlbumRequest(
    String title,
    String artistId,
    Date releaseDate,
    Integer tracksCount,
    Integer durationSeconds
) {

}
