package com.cinemamanagementsoftware.persistenceservice.entities;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "seating_rows")
public class SeatingRowEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private int rowNr;
    
    @OneToMany(mappedBy = "row", cascade = CascadeType.ALL)
    private List<SeatEntity> seats;
    
    @ManyToOne
    @JoinColumn(name = "cinema_hall_id", nullable = false)
    private CinemaHallEntity cinemaHall;
    
    public SeatingRowEntity() {}

    public SeatingRowEntity(int rowNr, CinemaHallEntity cinemaHall) {
        this.rowNr = rowNr;
        this.cinemaHall = cinemaHall;
    }

    // Getters & Setters
    public Long getId() { return id; }

    public int getrowNr() { return rowNr; }
    public void setrowNr(int rowNr) { this.rowNr = rowNr; }

    public CinemaHallEntity getCinemaHall() { return cinemaHall; }
    public void setCinemaHall(CinemaHallEntity cinemaHall) { this.cinemaHall = cinemaHall; }

    public List<SeatEntity> getSeats() { return seats; }
    public void setSeats(List<SeatEntity> seats) { this.seats = seats; }
}