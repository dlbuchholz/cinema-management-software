package com.cinemamanagementsoftware.persistenceservice.entities;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "cinema_halls")
public class CinemaHallEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @ManyToOne
    @JoinColumn(name = "cinema_id", nullable = false)
    private CinemaEntity cinema;
    
    @OneToMany(mappedBy = "cinemaHall", cascade = CascadeType.ALL)
    private List<SeatingRowEntity> seatingRows;
}