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
}