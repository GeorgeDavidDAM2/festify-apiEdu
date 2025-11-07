package com.GeorgeDavidDAM2.festify_apiEdu.web.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.GeorgeDavidDAM2.festify_apiEdu.dto.response.AlbumResponse;
import com.GeorgeDavidDAM2.festify_apiEdu.services.AlbumService;

@CrossOrigin(origins = "*")
@RestController
public class AlbumController {
    
    private final AlbumService albumService;
    

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    // pageable
    //example
    @GetMapping("/artists/{id}/albums")
    public List<AlbumResponse> listAlbums(@PathVariable Long id) {
        return albumService.listAlbums(id);
    }

}
