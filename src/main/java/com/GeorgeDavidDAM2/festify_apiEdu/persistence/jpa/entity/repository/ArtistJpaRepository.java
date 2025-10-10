package com.GeorgeDavidDAM2.festify_apiEdu.persistence.jpa.entity.repository;

import com.GeorgeDavidDAM2.festify_apiEdu.persistence.jpa.entity.ArtistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistJpaRepository extends JpaRepository<ArtistEntity, Long> {} //el tipo long es el identificador del artista , ArtistEntity es la entidad que representa a un artista en la base de datos

