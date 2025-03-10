package com.cinemamanagementsoftware.persistenceservice.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "tickets")
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private CustomerEntity customer;
    
    @ManyToOne
    @JoinColumn(name = "screening_id", nullable = false)
    private ScreeningEntity screening;
    
    private Boolean isBooked;
    
    @ManyToOne 
    @JoinColumn(name = "seatId", nullable = false)
    private SeatEntity seat;
    
    @Column(nullable = false)
    private Double price;
    
    public void setId(Long id) {this.id = id;}
    public Long getId() {return this.id;}
    
    public void setOwner(CustomerEntity customer) {this.customer = customer;}
    public CustomerEntity getOwner() {return this.customer;}
    
    public void setScreening(ScreeningEntity screening) {this.screening = screening;}
    public ScreeningEntity getScreening() {return this.screening;}
    
    public void setBookedStatus(Boolean bookedStatus) {this.isBooked = bookedStatus;}
    public Boolean getBookedStatus() {return this.isBooked;}

    public void setSeat(SeatEntity seat) {this.seat = seat;}
    public SeatEntity getSeat() {return this.seat;}

    public void setPrice(Double price) {this.price = price;}
    public Double getPrice() {return this.price;}
}