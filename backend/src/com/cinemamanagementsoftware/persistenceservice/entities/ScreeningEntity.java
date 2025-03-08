package com.cinemamanagementsoftware.persistenceservice.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "screenings")
public class ScreeningEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private MovieEntity movie;

    @ManyToOne
    @JoinColumn(name = "cinema_hall_id", nullable = false)
    private CinemaHallEntity cinemaHall;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private double startTime;

    @Column(nullable = false)
    private double endTime;

    public ScreeningEntity() {}

    public ScreeningEntity(MovieEntity movie, CinemaHallEntity cinemaHall, Date date, double startTime, double endTime) {
        this.movie = movie;
        this.cinemaHall = cinemaHall;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Long getId() { return id; }

    public MovieEntity getMovie() { return movie; }
    public void setMovie(MovieEntity movie) { this.movie = movie; }

    public CinemaHallEntity getCinemaHall() { return cinemaHall; }
    public void setCinemaHall(CinemaHallEntity cinemaHall) { this.cinemaHall = cinemaHall; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public double getStartTime() { return startTime; }
    public void setStartTime(double startTime) { this.startTime = startTime; }

    public double getEndTime() { return endTime; }
    public void setEndTime(double endTime) { this.endTime = endTime; }
}