package com.GeorgeDavidDAM2.festify_apiEdu.dto.request;

public record FestivalRequest(
    String titulo,
    String descripcion,
    String city,
    String fechaInicio,
    String fechaFin,
    Integer precioMin,
    Integer precioMax
) {

}
