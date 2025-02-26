package com.cinemamanagementsoftware.persistenceservice.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "seats")
public class SeatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private int rowNumber;
    
    @Column(nullable = false)
    private int seatNumber;
}