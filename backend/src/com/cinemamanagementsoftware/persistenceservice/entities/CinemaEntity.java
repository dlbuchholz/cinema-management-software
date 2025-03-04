package com.cinemamanagementsoftware.persistenceservice.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
@Table(name = "cinemas")
public class CinemaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;
    
    @ManyToOne(targetEntity = CinemaOwnerEntity.class)
    @JoinColumn(name = "owner_id")
	private CinemaOwnerEntity owner;
    
    @OneToMany(mappedBy = "cinema", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CinemaHallEntity> cinemaHalls;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
}