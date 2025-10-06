package com.GeorgeDavidDAM2.festify_apiEdu.dto.response;

import java.util.List;

public record ArtistResumeResponse(String id, String name, List<String> genres, Integer listeners) {
}
