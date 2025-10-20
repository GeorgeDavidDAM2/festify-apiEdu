package com.GeorgeDavidDAM2.festify_apiEdu.dto.request;

import java.util.List;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record ArtistResumeRequest(
    String  id, 

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 20, message = "El nombre no puede tener más de 100 caracteres")
    String name, 

    String country, 

    @NotEmpty(message = "Debe haber minimo 1 género")
    List<String> genres, 
    
    @Min(value = 10000, message = "El número de oyentes no puede ser menor de 10000")
    @Positive(message = "El número de oyentes debe ser un número positivo")
    Integer listeners,

    @Pattern(regexp = "Activo|Inactivo", message = "El estado debe ser 'Activo' o 'Inactivo'")
    String status,

    @Size(max = 500, message = "La biografía no puede tener más de 500 caracteres")
    String biography) 

    {



}
