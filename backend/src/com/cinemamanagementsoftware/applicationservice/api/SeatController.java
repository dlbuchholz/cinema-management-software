package com.cinemamanagementsoftware.applicationservice.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/seats")
public class SeatController {

    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;

    public SeatController(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper) {
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
    }

    // Fetch all seats
    @GetMapping
    public Object getAllSeats() {
        Object response = rabbitTemplate.convertSendAndReceive("seat.fetch.all", "");
        return Objects.requireNonNullElse(response, "{\"status\":\"error\",\"message\":\"No seats found\"}");
    }

    // Fetch a specific seat by ID
    @GetMapping("/{id}")
    public Object getSeatById(@PathVariable Long id) {
        Object response = rabbitTemplate.convertSendAndReceive("seat.fetch", id);
        return Objects.requireNonNullElse(response, "{\"status\":\"error\",\"message\":\"Seat not found\"}");
    }

    // Create a new seat
    @PostMapping
    public Object createSeat(@RequestBody Map<String, String> seatData) {
        Object response = rabbitTemplate.convertSendAndReceive("seat.create", seatData);
        return Objects.requireNonNullElse(response, "{\"status\":\"error\",\"message\":\"Seat creation failed\"}");
    }

    // Update an existing seat
    @PatchMapping("/{id}")
    public Object updateSeat(@PathVariable Long id, @RequestBody Map<String, String> seatData) {
        seatData.put("id", String.valueOf(id));
        Object response = rabbitTemplate.convertSendAndReceive("seat.update", seatData);
        return Objects.requireNonNullElse(response, "{\"status\":\"error\",\"message\":\"Seat update failed\"}");
    }

    // Delete a seat
    @DeleteMapping("/{id}")
    public Object deleteSeat(@PathVariable Long id) {
        Object response = rabbitTemplate.convertSendAndReceive("seat.delete", id);
        return Objects.requireNonNullElse(response, "{\"status\":\"error\",\"message\":\"Seat deletion failed\"}");
    }
}