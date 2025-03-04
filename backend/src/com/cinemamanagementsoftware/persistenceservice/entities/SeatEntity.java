package com.cinemamanagementsoftware.persistenceservice.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "seats")
public class SeatEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(nullable = false)
    private int seatNumber;
    
    @ManyToOne
    @JoinColumn(name = "seating_row_id", nullable = false)
    private SeatingRowEntity row;
    
    public SeatEntity() {}

    public SeatEntity(int seatNumber, SeatingRowEntity row) {
        this.seatNumber = seatNumber;
        this.row = row;
    }

    public Long getId() { return id; }

    public int getSeatNumber() { return seatNumber; }
    public void setSeatNumber(int seatNumber) { this.seatNumber = seatNumber; }

    public SeatingRowEntity getRow() { return row; }
    public void setRow(SeatingRowEntity row) { this.row = row; }
}