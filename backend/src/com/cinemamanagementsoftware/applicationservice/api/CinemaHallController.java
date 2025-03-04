package com.cinemamanagementsoftware.applicationservice.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.*;

import cinemaManagementSoftware.CinemaHall;

import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/halls")
public class CinemaHallController {

    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;

    public CinemaHallController(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper) {
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
    }

    // Fetch all Cinema Halls
    @GetMapping
    public Object getAllCinemaHalls() {
        Object response = rabbitTemplate.convertSendAndReceive("cinemaHall.fetch.all", "");
        return Objects.requireNonNullElse(response, "{\"status\":\"error\",\"message\":\"No cinema halls found\"}");
    }

    // Fetch a specific Cinema Hall by ID
    @GetMapping("/{id}")
    public Object getCinemaHallById(@PathVariable("id") Long id) {
        Object response = rabbitTemplate.convertSendAndReceive("cinemaHall.fetch", id);
        return Objects.requireNonNullElse(response, "{\"status\":\"error\",\"message\":\"Cinema Hall not found\"}");
    }

    // Create a new Cinema Hall with Ecore validation
    @PostMapping
    public String createCinemaHall(@RequestBody Map<String, String> cinemaHallData) {
        try {
            Object response = rabbitTemplate.convertSendAndReceive("cinemaHall.create", cinemaHallData);
            return response != null ? response.toString() : "{\"status\":\"error\",\"message\":\"Timeout\"}";
        } catch (Exception e) {
            return "{\"status\":\"error\",\"message\":\"Error processing cinema hall creation: " + e.getMessage() + "\"}";
        }
    }

    // Update an existing Cinema Hall
    @PatchMapping("/{id}")
    public Object updateCinemaHall(@PathVariable Long id, @RequestBody Map<String, String> cinemaHallData) {
        cinemaHallData.put("id", String.valueOf(id));
        Object response = rabbitTemplate.convertSendAndReceive("cinemaHall.update", cinemaHallData);
        return Objects.requireNonNullElse(response, "{\"status\":\"error\",\"message\":\"Cinema Hall update failed\"}");
    }

    // Delete a Cinema Hall
    @DeleteMapping("/{id}")
    public Object deleteCinemaHall(@PathVariable Long id) {
        Object response = rabbitTemplate.convertSendAndReceive("cinemaHall.delete", id);
        return Objects.requireNonNullElse(response, "{\"status\":\"error\",\"message\":\"Cinema Hall deletion failed\"}");
    }
}