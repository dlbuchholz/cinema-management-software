package com.cinemamanagementsoftware.persistenceservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinemamanagementsoftware.persistenceservice.entities.CinemaEntity;

/**
 * Repository interface for managing Cinema entities in the MySQL database.
 * 
 * This interface extends JpaRepository to provide built-in CRUD operations, 
 * eliminating the need for manual SQL queries.
 * 
 * Spring Data JPA will automatically implement this interface to allow 
 * easy access to Cinema records.
 */

@Repository
public interface CinemaRepository extends JpaRepository<CinemaEntity, Long> {
}
