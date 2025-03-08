package com.cinemamanagementsoftware.persistenceservice.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cinemamanagementsoftware.persistenceservice.entities.CinemaHallEntity;


@Repository
public interface CinemaHallRepository extends JpaRepository<CinemaHallEntity, Long> {
	 @Query("SELECT ch FROM CinemaHallEntity ch " +
	           "LEFT JOIN FETCH ch.seatingRows sr " +
	           "LEFT JOIN FETCH sr.seats " +
	           "WHERE ch.id = :id")
	    Optional<CinemaHallEntity> findByIdWithSeatingRows(@Param("id") Long id);
	
	 @Query("SELECT DISTINCT ch FROM CinemaHallEntity ch " +
	           "LEFT JOIN FETCH ch.seatingRows sr " +
	           "LEFT JOIN FETCH sr.seats")
	    List<CinemaHallEntity> findAllWithSeatingRows();
}
