package com.GeorgeDavidDAM2.festify_apiEdu.services;

import java.util.List;

import com.GeorgeDavidDAM2.festify_apiEdu.dto.request.ArtistResumeRequest;
import com.GeorgeDavidDAM2.festify_apiEdu.dto.response.ArtistDetailResponse;
import com.GeorgeDavidDAM2.festify_apiEdu.dto.response.ArtistResumeResponse;

public interface ArtistService {
    List<ArtistResumeResponse> listArtists();
    ArtistDetailResponse getArtistById(String id);
    ArtistResumeResponse createArtist(ArtistResumeRequest artistRequest);
    void deleteArtist(String id);
    

}
