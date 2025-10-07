package com.GeorgeDavidDAM2.festify_apiEdu.persistence.jpa.entity;

import jakarta.persistence.*;

import java.util.List;
//Mappea los datos de la base de dato a un objeto Java
//Entidad JPA que representa a un artista en la base de datos
@Entity
@Table(name = "artists")
public class ArtistEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private List<String> genres;
    private String country;
    private Double listeners;
    private String status;

    public ArtistEntity() {
    }

    public ArtistEntity(Long id, String name, List<String> genres, String country, Double listeners, String status) {
        this.id = id;
        this.name = name;
        this.genres = genres;
        this.country = country;
        this.listeners = listeners;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getListeners() {
        return listeners;
    }

    public void setListeners(Double listeners) {
        this.listeners = listeners;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
