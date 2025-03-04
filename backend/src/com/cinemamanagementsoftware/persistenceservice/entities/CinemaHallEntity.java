package com.cinemamanagementsoftware.persistenceservice.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    private List<SeatingRowEntity> seatingRows;
    
    public CinemaHallEntity() {}

    public CinemaHallEntity(String name, CinemaEntity cinema) {
        this.name = name;
        this.cinema = cinema;
    }

    // ✅ Getters & Setters
    public Long getId() { return id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public CinemaEntity getCinema() { return cinema; }
    public void setCinema(CinemaEntity cinema) { this.cinema = cinema; }

    public List<SeatingRowEntity> getSeatingRows() { return seatingRows; }
    public void setSeatingRows(List<SeatingRowEntity> seatingRows) { this.seatingRows = seatingRows; }
}