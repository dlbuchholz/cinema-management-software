package com.cinemamanagementsoftware.persistenceservice.entities;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "customers")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<TicketEntity> tickets;
}

