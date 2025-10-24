package com.GeorgeDavidDAM2.festify_apiEdu.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.GeorgeDavidDAM2.festify_apiEdu.dto.request.ArtistResumeRequest;
import com.GeorgeDavidDAM2.festify_apiEdu.dto.response.ArtistDetailResponse;
import com.GeorgeDavidDAM2.festify_apiEdu.dto.response.ArtistResumeResponse;
import com.GeorgeDavidDAM2.festify_apiEdu.services.ArtistService;

import jakarta.validation.Valid;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ArtistController {

    private ArtistService artistService;

    @Autowired //inyección de dependencias
    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping("/artists")
    public List<ArtistResumeResponse> listArtists() {
        return this.artistService.listArtists();
    }

    @GetMapping(path="/artists/{id}")  // Mapea las solicitudes GET a /artists/{id} , es decir, cuando alguien acceda a /artists/ART-001 se ejecutará este método
    public ArtistDetailResponse getArtistById(@PathVariable String id) { // PathVariable indica que el valor de id se obtiene de la URL
        ArtistDetailResponse artist = this.artistService.getArtistById(id);
        return artist; 
    }
    
    @PostMapping(path = "/artists")
    public ArtistResumeResponse createArtist(@Valid @RequestBody ArtistResumeRequest artistRequest) { //Es de tipo ArtistResumeResponse porque devuelve el artista creado
        return this.artistService.createArtist(artistRequest);
    }

    @DeleteMapping(path = "/artists/{id}")
    public void deleteArtist(@PathVariable String id) { //el pathVariable va con ids para sacarlas de la url
        this.artistService.deleteArtist(id);
    }

    @PutMapping(path = "/artists/{id}")
    public ArtistDetailResponse updateArtist(@PathVariable String id, @Valid @RequestBody ArtistResumeRequest artistRequest) {
        return this.artistService.updateArtist(id, artistRequest);
    }
}
