package com.cinemamanagementsoftware.persistenceservice.consumers;

import com.cinemamanagementsoftware.persistenceservice.entities.CinemaEntity;
import com.cinemamanagementsoftware.persistenceservice.repositories.CinemaRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import cinemaManagementSoftware.impl.CinemaImpl;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class CinemaCommandConsumer {
    private final CinemaRepository cinemaRepository;
    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;

    @Autowired
    public CinemaCommandConsumer(CinemaRepository cinemaRepository, RabbitTemplate rabbitTemplate, ObjectMapper objectMapper) {
        this.cinemaRepository = cinemaRepository;
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
    }

    @RabbitListener(queues = "cinema.fetch")
    public String fetchCinema(String responseQueue) {
        try {
        	List<CinemaEntity> cinemas = cinemaRepository.findAll();
            System.out.println("📊 Found " + cinemas.size() + " cinemas in database.");

            Optional<CinemaEntity> existingCinema = cinemas.stream().findFirst();

            if (existingCinema.isPresent()) {
                // ✅ Send the found cinema as JSON
                String jsonResponse = objectMapper.writeValueAsString(existingCinema.get());
                System.out.println("✅ Found existing cinema: " + existingCinema.get().getName());
                System.out.println(responseQueue);
                return jsonResponse;
            } else {
            	System.out.println("⚠ No cinema found, returning empty response.");
            }
        } catch (Exception e) {
            System.err.println("Error fetching cinema: " + e.getMessage());
        }
        return "{}";
    }

    @RabbitListener(queues = "cinema.create")
    public String createCinema(String cinemaJson) {
        try {
            // Extract and deserialize JSON
            String extractedJson = extractNestedJson(cinemaJson, "cinema");
            CinemaEntity cinema = objectMapper.readValue(extractedJson, CinemaEntity.class);
            CinemaEntity savedCinema = cinemaRepository.save(cinema);
            return objectMapper.writeValueAsString(savedCinema);

        } catch (Exception e) {
            System.err.println("❌ Error creating CinemaEntity: " + e.getMessage());
            return "{}"; // Return empty JSON object in case of error
        }
    }

    @RabbitListener(queues = "cinema.update")
    public void updateCinema(String cinemaJson) {
        try {
        	String extractedJson = extractNestedJson(cinemaJson, "cinema");
            CinemaEntity updatedCinema = objectMapper.readValue(extractedJson, CinemaEntity.class);
            Optional<CinemaEntity> existingCinema = cinemaRepository.findById(updatedCinema.getId());

            if (existingCinema.isPresent()) {
                CinemaEntity cinema = existingCinema.get();
                cinema.setName(updatedCinema.getName());
                cinema.setLocation(updatedCinema.getLocation());
                cinemaRepository.save(cinema);
                System.out.println("🎬 Cinema updated: " + cinema.getName());
            } else {
                System.err.println("❌ Update failed: Cinema with ID " + updatedCinema.getId() + " not found.");
            }
        } catch (Exception e) {
            System.err.println("❌ Error updating CinemaEntity: " + e.getMessage());
            System.err.println(cinemaJson);
        }
    }

    @RabbitListener(queues = "cinema.delete")
    public void deleteCinema(Long cinemaId) {
        if (cinemaRepository.existsById(cinemaId)) {
            cinemaRepository.deleteById(cinemaId);
            System.out.println("🗑️ Cinema deleted with ID: " + cinemaId);
        } else {
            System.err.println("❌ Delete failed: Cinema with ID " + cinemaId + " not found.");
        }
    }
    
    private String extractNestedJson(String json, String key) {
        try {
            JsonNode rootNode = objectMapper.readTree(json);
            JsonNode extractedNode = rootNode.get(key);

            if (extractedNode != null) {
                return objectMapper.writeValueAsString(extractedNode);
            } else {
                return json; // Return original JSON if the key doesn't exist
            }
        } catch (Exception e) {
            System.err.println("❌ Error extracting '" + key + "' from JSON: " + e.getMessage());
            return json;
        }
    }
}