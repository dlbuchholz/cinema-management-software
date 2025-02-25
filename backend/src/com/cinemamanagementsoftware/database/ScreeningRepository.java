package com.cinemamanagementsoftware.database;

import cinemaManagementSoftware.impl.ScreeningImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing Screening entities in the MySQL database.
 * 
 * This interface provides an abstraction over database operations for screenings,
 * allowing for automatic query execution using Spring Data JPA.
 */

@Repository
public interface ScreeningRepository extends JpaRepository<ScreeningImpl, Long> {
	
}
