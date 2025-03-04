package com.cinemamanagementsoftware.applicationservice.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/seatingrows")
public class SeatingRowController {

    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;

    public SeatingRowController(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper) {
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
    }

    // Fetch all seating rows
    @GetMapping
    public Object getAllSeatingRows() {
        Object response = rabbitTemplate.convertSendAndReceive("seatingRow.fetch.all", "");
        return Objects.requireNonNullElse(response, "{\"status\":\"error\",\"message\":\"No seating rows found\"}");
    }

    // Fetch a specific seating row by ID
    @GetMapping("/{id}")
    public Object getSeatingRowById(@PathVariable Long id) {
        Object response = rabbitTemplate.convertSendAndReceive("seatingRow.fetch", id);
        return Objects.requireNonNullElse(response, "{\"status\":\"error\",\"message\":\"Seating row not found\"}");
    }

    // Create a new seating row
    @PostMapping
    public Object createSeatingRow(@RequestBody Map<String, String> seatingRowData) {
        Object response = rabbitTemplate.convertSendAndReceive("seatingRow.create", seatingRowData);
        return Objects.requireNonNullElse(response, "{\"status\":\"error\",\"message\":\"Seating row creation failed\"}");
    }

    // Update an existing seating row
    @PatchMapping("/{id}")
    public Object updateSeatingRow(@PathVariable Long id, @RequestBody Map<String, String> seatingRowData) {
        seatingRowData.put("id", String.valueOf(id));
        Object response = rabbitTemplate.convertSendAndReceive("seatingRow.update", seatingRowData);
        return Objects.requireNonNullElse(response, "{\"status\":\"error\",\"message\":\"Seating row update failed\"}");
    }

    // Delete a seating row
    @DeleteMapping("/{id}")
    public Object deleteSeatingRow(@PathVariable Long id) {
        Object response = rabbitTemplate.convertSendAndReceive("seatingRow.delete", id);
        return Objects.requireNonNullElse(response, "{\"status\":\"error\",\"message\":\"Seating row deletion failed\"}");
    }
}