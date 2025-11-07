package com.GeorgeDavidDAM2.festify_apiEdu.mapper;

import com.GeorgeDavidDAM2.festify_apiEdu.dto.response.FestivalResponse;
import com.GeorgeDavidDAM2.festify_apiEdu.persistence.jpa.entity.FestivalEntity;

public class FestivalMapper {
    public static FestivalResponse toFestivalResponse(FestivalEntity festival) {
        return new FestivalResponse(
            festival.getId(),
            festival.getTitulo(),
            festival.getDescripcion(),
            festival.getCity(),
            festival.getFechaInicio().toString(),
            festival.getFechaFin().toString(),
            Math.round(festival.getPrecioMin()),
            Math.round(festival.getPrecioMax()) //Redondea a integer
        );
    }
}
