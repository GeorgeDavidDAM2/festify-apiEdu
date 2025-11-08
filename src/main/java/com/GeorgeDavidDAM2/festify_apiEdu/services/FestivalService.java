package com.GeorgeDavidDAM2.festify_apiEdu.services;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;

import com.GeorgeDavidDAM2.festify_apiEdu.dto.response.FestivalResponse;

public interface FestivalService {
    List<FestivalResponse> listAllFestivals();
    Page<FestivalResponse> getFestivalsPaginados(String search, Pageable pageable);
}
