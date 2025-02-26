package com.cinemamanagementsoftware.persistenceservice.consumers;

import com.cinemamanagementsoftware.persistenceservice.entities.CinemaEntity;
import com.cinemamanagementsoftware.persistenceservice.repositories.CinemaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import cinemaManagementSoftware.impl.CinemaImpl;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@Component
public class CinemaCommandConsumer {
    private final CinemaRepository cinemaRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    public CinemaCommandConsumer(CinemaRepository cinemaRepository, ObjectMapper objectMapper) {
        this.cinemaRepository = cinemaRepository;
        this.objectMapper = objectMapper;
    }

    @RabbitListener(queues = "cinema.create")
    public void createCinema(String cinemaJson) {
        try {
            // Deserialize JSON directly into the entity class
            CinemaEntity cinema = objectMapper.readValue(cinemaJson, CinemaEntity.class);
            cinemaRepository.save(cinema);
            System.out.println("🎬 Cinema saved: " + cinema.getName());
        } catch (Exception e) {
            System.err.println("❌ Error deserializing CinemaEntity: " + e.getMessage());
        }
    }

    @RabbitListener(queues = "cinema.update")
    public void updateCinema(Map<String, Object> updateData) {
        Long id = ((Number) updateData.get("id")).longValue();
        Optional<CinemaEntity> optionalCinema = cinemaRepository.findById(id);
        if (optionalCinema.isPresent()) {
            CinemaImpl cinema = optionalCinema.get();
            if (updateData.containsKey("name")) {
                cinema.setName((String) updateData.get("name"));
            }
            if (updateData.containsKey("location")) {
                cinema.setLocation((String) updateData.get("location"));
            }
            cinemaRepository.save(cinema);
            System.out.println("🎬 Updated cinema: " + cinema.getName());
        }
    }

    @RabbitListener(queues = "cinema.delete")
    public void deleteCinema(Long id) {
        cinemaRepository.deleteById(id);
        System.out.println("❌ Deleted cinema with ID: " + id);
    }
}