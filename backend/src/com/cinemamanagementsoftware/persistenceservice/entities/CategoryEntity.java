package com.cinemamanagementsoftware.persistenceservice.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String name;

	public String getName() {
		return name;
	}

	public CategoryEntity(String name) {
		this.name = name;
	}

	public CategoryEntity() {}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return this.id;
	}
}