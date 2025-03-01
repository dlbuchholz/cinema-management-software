package com.cinemamanagementsoftware.persistenceservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinemamanagementsoftware.persistenceservice.entities.SeatingRowEntity;


@Repository
public interface SeatingRowRepository extends JpaRepository<SeatingRowEntity, Long> {
}
