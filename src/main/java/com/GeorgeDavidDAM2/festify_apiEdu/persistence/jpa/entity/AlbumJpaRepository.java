package com.GeorgeDavidDAM2.festify_apiEdu.persistence.jpa.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumJpaRepository extends JpaRepository<AlbumEntity, Long> {
    
    List<AlbumEntity> findByArtistId(Long artistId);
    
    

}
