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
    private String fechaInicio;

    @Column(name="fecha_fin", nullable = false)
    private String fechaFin;

    @Column(name="precio_min", nullable = false)
    private Integer precioMin;

    @Column(name="precio_max", nullable = false)
    private Integer precioMax;

    public FestivalEntity() {
    }
    public FestivalEntity(Long id, String titulo, String descripcion, String city, String fechaInicio,
            String fechaFin, Integer precioMin, Integer precioMax) {
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
    public String getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public String getFechaFin() {
        return fechaFin;
    }
    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }
    public Integer getPrecioMin() {
        return precioMin;
    }
    public void setPrecioMin(Integer precioMin) {
        this.precioMin = precioMin;
    }
    public Integer getPrecioMax() {
        return precioMax;
    }
    public void setPrecioMax(Integer precioMax) {
        this.precioMax = precioMax;
    }

    
}
