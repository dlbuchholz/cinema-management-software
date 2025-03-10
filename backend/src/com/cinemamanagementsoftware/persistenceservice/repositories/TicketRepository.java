package com.cinemamanagementsoftware.persistenceservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinemamanagementsoftware.persistenceservice.entities.SeatEntity;
import com.cinemamanagementsoftware.persistenceservice.entities.TicketEntity;


@Repository
public interface TicketRepository extends JpaRepository<TicketEntity, Long> {
    List<TicketEntity> findByCustomerIdAndScreeningId(Long customerId, Long screeningId);
    List<TicketEntity> findByScreeningId(Long screeningId);
    List<TicketEntity> findByCustomerId(Long customerId);
    Boolean existsByScreeningIdAndSeatId(Long screeningId, Long seatId);
}
