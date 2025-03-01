package com.cinemamanagementsoftware.persistenceservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinemamanagementsoftware.persistenceservice.entities.SeatEntity;


@Repository
public interface SeatRepository extends JpaRepository<SeatEntity, Long> {
}
