package com.GeorgeDavidDAM2.festify_apiEdu.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import com.GeorgeDavidDAM2.festify_apiEdu.dto.response.FestivalResponse;
import com.GeorgeDavidDAM2.festify_apiEdu.services.FestivalService;

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
            Pageable pageable,
            @RequestParam(required = false) String search
    ) {
       return festivalService.getFestivalsPaginados(search, pageable);
    }
}
