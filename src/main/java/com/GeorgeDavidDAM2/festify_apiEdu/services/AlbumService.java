package com.GeorgeDavidDAM2.festify_apiEdu.services;

import java.util.List;

import com.GeorgeDavidDAM2.festify_apiEdu.dto.response.AlbumResponse;

public interface AlbumService {
    List<AlbumResponse> listAlbums(Long id);

    
}
