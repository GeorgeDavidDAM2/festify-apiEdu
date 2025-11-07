package com.GeorgeDavidDAM2.festify_apiEdu.persistence.jpa.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "albums")
public class AlbumEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    
    @Column(name = "artist_id", nullable = false)
    private Long artistId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "release_date", nullable = false)
    private Date releaseDate;

    @Column(name = "tracks_count", nullable = false)
    private Integer tracksCount;

    @Column(name = "duration_seconds", nullable = false)
    private Integer durationSeconds;

    public AlbumEntity() {
    }

    public AlbumEntity(Long id, Long artistId, String title,  Date releaseDate, Integer tracksCount, Integer durationSeconds) {
        this.id = id;
        this.artistId = artistId;
        this.title = title;
        this.releaseDate = releaseDate;
        this.tracksCount = tracksCount;
        this.durationSeconds = durationSeconds;
    }

    public String getTitle() {
        return title;
    }
    public Long getArtistId() {
        return artistId;
    }
    public Long getId() {
        return id;
    }
    public Date getReleaseDate() {
        return releaseDate;
    }
    public Integer getTracksCount() {
        return tracksCount;
    }
    public Integer getDurationSeconds() {
        return durationSeconds;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setArtistId(Long artistId) {
        this.artistId = artistId;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }   
    public void setTracksCount(Integer tracksCount) {
        this.tracksCount = tracksCount;
    }
    public void setDurationSeconds(Integer durationSeconds) {
        this.durationSeconds = durationSeconds;
    }

}
