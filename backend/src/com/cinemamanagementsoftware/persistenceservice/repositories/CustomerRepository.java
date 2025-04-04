package com.cinemamanagementsoftware.persistenceservice.repositories;

import com.cinemamanagementsoftware.persistenceservice.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
    Optional<CustomerEntity> findByEmail(String email);
}