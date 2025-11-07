package com.GeorgeDavidDAM2.festify_apiEdu.persistence.jpa.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GeorgeDavidDAM2.festify_apiEdu.persistence.jpa.entity.FestivalEntity;

public interface FestivalJpaRepository extends JpaRepository<FestivalEntity, Long> {

    
}
