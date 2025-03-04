package com.cinemamanagementsoftware.persistenceservice.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "movies")
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String title;
    
    @Column(nullable = false)
    private String genre;
    
    @Column(nullable = false)
    private String description;
    
    // Default Constructor (Required for JPA)
    public MovieEntity() {}

    public MovieEntity(String title, String description, String genre) {
        this.title = title;
        this.description = description;
        this.genre = genre;
    }

    public Long getId() { return id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }
}