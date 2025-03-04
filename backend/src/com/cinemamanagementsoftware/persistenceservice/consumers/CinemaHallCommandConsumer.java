package com.cinemamanagementsoftware.persistenceservice.consumers;

import com.cinemamanagementsoftware.persistenceservice.entities.CinemaEntity;
import com.cinemamanagementsoftware.persistenceservice.entities.CinemaHallEntity;
import com.cinemamanagementsoftware.persistenceservice.repositories.CinemaHallRepository;
import com.cinemamanagementsoftware.persistenceservice.repositories.CinemaRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate6.Hibernate6Module;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CinemaHallCommandConsumer {

    private final CinemaHallRepository cinemaHallRepository;
    private final CinemaRepository cinemaRepository;
    private final ObjectMapper objectMapper;

    public CinemaHallCommandConsumer(CinemaHallRepository cinemaHallRepository, CinemaRepository cinemaRepository, ObjectMapper objectMapper) {
        this.cinemaHallRepository = cinemaHallRepository;
        this.cinemaRepository = cinemaRepository;
        this.objectMapper = objectMapper;
        objectMapper.registerModule(new Hibernate6Module());
    }

    // Fetch all Cinema Halls
    @RabbitListener(queues = "cinemaHall.fetch.all")
    public String fetchAllCinemaHalls() {
        try {
            List<CinemaHallEntity> halls = cinemaHallRepository.findAll();
            return objectMapper.writeValueAsString(halls);
        } catch (Exception e) {
            return "{\"status\":\"error\",\"message\":\"Failed to fetch cinema halls\"}";
        }
    }

    // Fetch a Cinema Hall by ID
    @RabbitListener(queues = "cinemaHall.fetch")
    public String fetchCinemaHall(Long id) {
        try {
            Optional<CinemaHallEntity> hall = cinemaHallRepository.findById(id);
            return hall.map(h -> {
                try {
                    return objectMapper.writeValueAsString(h);
                } catch (Exception e) {
                    return "{\"status\":\"error\",\"message\":\"Failed to serialize cinema hall\"}";
                }
            }).orElse("{\"status\":\"error\",\"message\":\"Cinema Hall not found\"}");
        } catch (Exception e) {
            return "{\"status\":\"error\",\"message\":\"Failed to fetch cinema hall\"}";
        }
    }
    
    @RabbitListener(queues = "cinemaHall.create")
    public String createCinemaHall(Map<String, Object> hallData) {
        try {
            // Validate required fields
            if (!hallData.containsKey("name") || !hallData.containsKey("cinema_id")) {
                return "{\"status\":\"error\",\"message\":\"Missing required fields: 'name' and 'cinema_id'\"}";
            }

            Long cinemaId = Long.valueOf(hallData.get("cinema_id").toString());
            Optional<CinemaEntity> cinemaOptional = cinemaRepository.findById(cinemaId);

            if (cinemaOptional.isEmpty()) {
                return "{\"status\":\"error\",\"message\":\"Cinema with ID " + cinemaId + " not found\"}";
            }

            CinemaEntity cinema = cinemaOptional.get();
            CinemaHallEntity newHall = new CinemaHallEntity();
            newHall.setName(hallData.get("name").toString());
            newHall.setCinema(cinema);

            cinemaHallRepository.save(newHall);
            return "{\"status\":\"success\",\"message\":\"Cinema Hall created successfully\"}";
        } catch (Exception e) {
            return "{\"status\":\"error\",\"message\":\"Error creating Cinema Hall: " + e.getMessage() + "\"}";
        }
    }


    // Update an existing Cinema Hall
    @RabbitListener(queues = "cinemaHall.update")
    public String updateCinemaHall(Map<String, String> hallData) {
        try {
            Long id = Long.parseLong(hallData.get("id"));
            Optional<CinemaHallEntity> hallOptional = cinemaHallRepository.findById(id);

            if (hallOptional.isEmpty()) {
                return "{\"status\":\"error\",\"message\":\"Cinema Hall not found\"}";
            }

            CinemaHallEntity hall = hallOptional.get();
            if (hallData.containsKey("name")) {
                hall.setName(hallData.get("name"));
            }
            if (hallData.containsKey("seatCapacity")) {
                //hall.setSeatCapacity(Integer.parseInt(hallData.get("seatCapacity")));
            }

            cinemaHallRepository.save(hall);
            return "{\"status\":\"success\",\"message\":\"Cinema Hall updated\"}";
        } catch (Exception e) {
            return "{\"status\":\"error\",\"message\":\"Cinema Hall update failed\"}";
        }
    }

    // Delete a Cinema Hall
    @RabbitListener(queues = "cinemaHall.delete")
    public String deleteCinemaHall(Long id) {
        try {
            cinemaHallRepository.deleteById(id);
            return "{\"status\":\"success\",\"message\":\"Cinema Hall deleted\"}";
        } catch (Exception e) {
            return "{\"status\":\"error\",\"message\":\"Cinema Hall deletion failed\"}";
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