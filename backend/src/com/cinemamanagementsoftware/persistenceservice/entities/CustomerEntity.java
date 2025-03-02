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
    
    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String telephone;

    // Default Constructor (Required for JPA)
    public CustomerEntity() {}

    // Constructor for New Customer
    public CustomerEntity(String email, String password, String name, String telephone) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.telephone = telephone;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }
}

