package com.cinemamanagementsoftware.persistenceservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinemamanagementsoftware.persistenceservice.entities.TicketEntity;


@Repository
public interface TicketRepository extends JpaRepository<TicketEntity, Long> {
}
