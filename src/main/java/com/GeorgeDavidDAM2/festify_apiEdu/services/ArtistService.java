package com.GeorgeDavidDAM2.festify_apiEdu.services;

import java.util.List;

import com.GeorgeDavidDAM2.festify_apiEdu.dto.request.ArtistResumeRequest;
import com.GeorgeDavidDAM2.festify_apiEdu.dto.response.ArtistResumeResponse;

public interface ArtistService {
    List<ArtistResumeResponse> listArtists();
    ArtistResumeResponse createArtist(ArtistResumeRequest artistRequest);

}
