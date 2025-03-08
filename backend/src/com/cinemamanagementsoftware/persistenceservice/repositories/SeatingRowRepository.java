package com.cinemamanagementsoftware.persistenceservice.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cinemamanagementsoftware.persistenceservice.entities.SeatingRowEntity;


@Repository
public interface SeatingRowRepository extends JpaRepository<SeatingRowEntity, Long> {
	@Query("SELECT sr FROM SeatingRowEntity sr LEFT JOIN FETCH sr.seats")
    List<SeatingRowEntity> findAllWithSeats();
	
	@Query("SELECT sr FROM SeatingRowEntity sr LEFT JOIN FETCH sr.seats WHERE sr.id = :id")
    Optional<SeatingRowEntity> findByIdWithSeats(@Param("id") Long id);
}
