package com.cinemamanagementsoftware.persistenceservice.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "screenings")
public class ScreeningEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private MovieEntity movie;
    
    @Column(nullable = false)
    private String screeningTime;
}