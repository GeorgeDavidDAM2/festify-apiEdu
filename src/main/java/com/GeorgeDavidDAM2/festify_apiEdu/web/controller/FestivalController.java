package com.GeorgeDavidDAM2.festify_apiEdu.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;

import com.GeorgeDavidDAM2.festify_apiEdu.dto.request.FestivalRequest;
import com.GeorgeDavidDAM2.festify_apiEdu.dto.response.FestivalResponse;
import com.GeorgeDavidDAM2.festify_apiEdu.services.FestivalService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
public class FestivalController {

    private FestivalService festivalService;

    @Autowired
    public FestivalController(FestivalService festivalService) {
        this.festivalService = festivalService;
    }

    /* 
    @GetMapping ("/festivals")
    public List<FestivalResponse> listAllFestivals() {
        return this.festivalService.listAllFestivals();
    } */

    @GetMapping("/festivals")
    public ResponseEntity<Page<FestivalResponse>> getFestivalsPaginados(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        // 1. Recibe 'page' y 'size' de la URL (gracias a @RequestParam)
        
        // 2. Llama a tu servicio (que ya funciona)
        Page<FestivalResponse> paginaDeFestivales = festivalService.getFestivalsPaginados(page, size);
        
        // 3. Devuelve la página completa. 
        // Spring Boot la convertirá a JSON automáticamente.
        return ResponseEntity.ok(paginaDeFestivales);
    }

    @PostMapping("/festivals")
    public FestivalResponse createFestival(@Valid @RequestBody FestivalRequest festivalRequest) {
        return this.festivalService.createFestival(festivalRequest);
    }

    @DeleteMapping("/festivals/{id}")
    public void deleteFestival(@PathVariable Long id) {
        this.festivalService.deleteFestival(id);
    }
    
    @GetMapping("/festivals/{id}")
    public FestivalResponse getFestivalById(@PathVariable Long id) {
        return this.festivalService.getFestivalById(id);
    }

}
