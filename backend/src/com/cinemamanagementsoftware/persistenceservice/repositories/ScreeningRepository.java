package com.cinemamanagementsoftware.persistenceservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinemamanagementsoftware.persistenceservice.entities.ScreeningEntity;

/**
 * Repository interface for managing Screening entities in the MySQL database.
 * 
 * This interface provides an abstraction over database operations for screenings,
 * allowing for automatic query execution using Spring Data JPA.
 */

@Repository
public interface ScreeningRepository extends JpaRepository<ScreeningEntity, Long> {
	List<ScreeningEntity> findByCinemaHallId(Long cinemaHallId);
    List<ScreeningEntity> findByMovieId(Long movieId);
	
}
