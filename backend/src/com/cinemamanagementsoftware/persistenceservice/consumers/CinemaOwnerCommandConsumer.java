package com.cinemamanagementsoftware.persistenceservice.consumers;

import java.util.Optional;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinemamanagementsoftware.persistenceservice.entities.CinemaOwnerEntity;
import com.cinemamanagementsoftware.persistenceservice.repositories.CinemaOwnerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CinemaOwnerCommandConsumer {

    @Autowired
    private CinemaOwnerRepository cinemaOwnerRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @RabbitListener(queues = "owner.fetchById")
    public String fetchOwnerById(String ownerId) {
        try {
            Long id = Long.valueOf(ownerId);
            Optional<CinemaOwnerEntity> ownerOpt = cinemaOwnerRepository.findById(id);

            if (ownerOpt.isEmpty()) {
                return "{\"status\":\"error\",\"message\":\"Cinema Owner not found.\"}";
            }

            return objectMapper.writeValueAsString(ownerOpt.get());
        } catch (Exception e) {
            return "{\"status\":\"error\",\"message\":\"Error retrieving owner: " + e.getMessage() + "\"}";
        }
    }

    @RabbitListener(queues = "owner.fetch")
    public String fetchOwnerByEmail(String email) {
        try {
            Optional<CinemaOwnerEntity> ownerOpt = cinemaOwnerRepository.findByEmail(email);

            if (ownerOpt.isEmpty()) {
                return "{\"status\":\"error\",\"message\":\"Cinema Owner not found.\"}";
            }

            return objectMapper.writeValueAsString(ownerOpt.get());
        } catch (Exception e) {
            return "{\"status\":\"error\",\"message\":\"Error retrieving owner: " + e.getMessage() + "\"}";
        }
    }

    @RabbitListener(queues = "owner.create")
    public String createOwner(String jsonOwner) {
        try {
            // Deserialize request payload
            CinemaOwnerEntity owner = objectMapper.readValue(jsonOwner, CinemaOwnerEntity.class);

            // Check if email already exists
            Optional<CinemaOwnerEntity> existingOwner = cinemaOwnerRepository.findByEmail(owner.getEmail());
            if (existingOwner.isPresent()) {
                return "{\"status\":\"error\",\"message\":\"Cinema owner already exists!\"}";
            }

            // Save owner to database
            cinemaOwnerRepository.save(owner);
            return "{\"status\":\"success\",\"message\":\"Cinema owner registered successfully!\"}";

        } catch (Exception e) {
            return "{\"status\":\"error\",\"message\":\"Error creating cinema owner: " + e.getMessage() + "\"}";
        }
    }
}

