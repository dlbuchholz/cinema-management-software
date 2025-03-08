package com.cinemamanagementsoftware.persistenceservice.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
    
    @OneToMany(mappedBy = "cinemaHall", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<SeatingRowEntity> seatingRows;
    
    public CinemaHallEntity() {}

    public CinemaHallEntity(String name, CinemaEntity cinema) {
        this.name = name;
        this.cinema = cinema;
    }

    // Getters & Setters
    public Long getId() { return id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public CinemaEntity getCinema() { return cinema; }
    public void setCinema(CinemaEntity cinema) { this.cinema = cinema; }

    public Set<SeatingRowEntity> getSeatingRows() { return seatingRows; }
    public void setSeatingRows(Set<SeatingRowEntity> seatingRows) { this.seatingRows = seatingRows; }
}