package com.GeorgeDavidDAM2.festify_apiEdu.persistence.jpa.entity;




import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "festivales")
public class FestivalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private String city;

    @Column(name="fecha_inicio", nullable = false)
    private Date fechaInicio;

    @Column(name="fecha_fin", nullable = false)
    private Date fechaFin;

    @Column(name="precio_min", nullable = false)
    private Float precioMin;

    @Column(name="precio_max", nullable = false)
    private Float precioMax;

    public FestivalEntity() {
    }
    public FestivalEntity(Long id, String titulo, String descripcion, String city, Date fechaInicio,
            Date fechaFin, Float precioMin, Float precioMax) {
            this.id = id;
            this.titulo = titulo;
            this.descripcion = descripcion;
            this.city = city;
            this.fechaInicio = fechaInicio;
            this.fechaFin = fechaFin;
            this.precioMin = precioMin;
            this.precioMax = precioMax;
    
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public Date getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public Date getFechaFin() {
        return fechaFin;
    }
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
    public Float getPrecioMin() {
        return precioMin;
    }
    public void setPrecioMin(Float precioMin) {
        this.precioMin = precioMin;
    }
    public Float getPrecioMax() {
        return precioMax;
    }
    public void setPrecioMax(Float precioMax) {
        this.precioMax = precioMax;
    }

    
}
