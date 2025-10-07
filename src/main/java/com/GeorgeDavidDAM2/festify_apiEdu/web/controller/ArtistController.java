package com.GeorgeDavidDAM2.festify_apiEdu.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.GeorgeDavidDAM2.festify_apiEdu.dto.response.ArtistResumeResponse;
import com.GeorgeDavidDAM2.festify_apiEdu.services.ArtistService;

import java.util.List;

@RestController
public class ArtistController {

    private ArtistService artistService;

    @Autowired
    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping("/artists")
    public List<ArtistResumeResponse> listArtists() {
        return this.artistService.listArtists();
    }

    @GetMapping(path="/artists/{id}")  // Mapea las solicitudes GET a /artists/{id} , es decir, cuando alguien acceda a /artists/ART-001 se ejecutará este método
    public ArtistResumeResponse getArtistById(@PathVariable String id) { // PathVariable indica que el valor de id se obtiene de la URL
        for (ArtistResumeResponse artist : artistService.listArtists()) { // Recorre la lista de artistas
            if (artist.id().equals(id)) { // Si el id del artista es igual al id pasado por la URL
                return artist; // Devuelve el artista
            }
        }
        return null; // Si no encuentra ningún artista, devuelve null 
    }
}
