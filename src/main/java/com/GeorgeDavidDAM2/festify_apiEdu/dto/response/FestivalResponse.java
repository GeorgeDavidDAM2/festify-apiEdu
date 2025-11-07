package com.GeorgeDavidDAM2.festify_apiEdu.dto.response;



public record FestivalResponse(
    Long id,
    String titulo,
    String descripcion,
    String city,
    String fechaInicio,
    String fechaFin,
    Integer precioMin,
    Integer precioMax
) {

}
