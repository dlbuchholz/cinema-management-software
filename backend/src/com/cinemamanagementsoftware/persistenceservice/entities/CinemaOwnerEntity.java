package com.cinemamanagementsoftware.persistenceservice.entities;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "cinema_owners")
public class CinemaOwnerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<CinemaEntity> cinemas;
}
