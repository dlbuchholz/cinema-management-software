package com.cinemamanagementsoftware.persistenceservice.entities;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "seating_rows")
public class SeatingRowEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToMany(mappedBy = "row", cascade = CascadeType.ALL)
    private List<SeatEntity> seats;
}