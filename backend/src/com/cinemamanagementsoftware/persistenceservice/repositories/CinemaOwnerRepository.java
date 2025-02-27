package com.cinemamanagementsoftware.persistenceservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinemamanagementsoftware.persistenceservice.entities.CinemaOwnerEntity;


@Repository
public interface CinemaOwnerRepository extends JpaRepository<CinemaOwnerEntity, Long> {
}
