package com.GeorgeDavidDAM2.festify_apiEdu.services.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.GeorgeDavidDAM2.festify_apiEdu.dto.response.FestivalResponse;
import com.GeorgeDavidDAM2.festify_apiEdu.mapper.FestivalMapper;
import com.GeorgeDavidDAM2.festify_apiEdu.persistence.jpa.entity.repository.FestivalJpaRepository;
import com.GeorgeDavidDAM2.festify_apiEdu.services.FestivalService;


@Service
public class FestivalServiceImpl implements FestivalService {

    

    private final FestivalJpaRepository festivalRepository;

    @Autowired
    public FestivalServiceImpl(FestivalJpaRepository festivalRepository) {
        this.festivalRepository = festivalRepository;
    }

    @Override
    public List<FestivalResponse> listAllFestivals() {
        return this.festivalRepository.findAll().stream()
              .map(FestivalMapper::toFestivalResponse) //toFestivalResponse es un método estático de la clase FestivalMapper que convierte un FestivalEntity en un FestivalResponse
              .toList();
    }

    
    public Page<FestivalResponse> getFestivalsPaginados(String search, Pageable pageable) {
        
        return festivalRepository.findAll(pageable).map(FestivalMapper::toFestivalResponse);
    }
}
