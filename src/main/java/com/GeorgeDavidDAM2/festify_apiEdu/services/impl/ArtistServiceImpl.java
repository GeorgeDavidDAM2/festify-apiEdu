package com.GeorgeDavidDAM2.festify_apiEdu.services.impl;

import com.GeorgeDavidDAM2.festify_apiEdu.services.ArtistService;
import com.GeorgeDavidDAM2.festify_apiEdu.dto.response.ArtistResumeResponse;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ArtistServiceImpl implements ArtistService {

    @Override
    public List<ArtistResumeResponse> listArtists() {
        // Aquí iría la lógica para obtener la lista de artistas, por ejemplo, desde una base de datos o una API externa.
        // Por ahora, devolvemos una lista vacía como ejemplo.
        return List.of(
            new ArtistResumeResponse("1", "Artist One", List.of("Pop", "Rock"), 1000),
            new ArtistResumeResponse("2", "Artist Two", List.of("Jazz"), 500)
        );
    }
}
