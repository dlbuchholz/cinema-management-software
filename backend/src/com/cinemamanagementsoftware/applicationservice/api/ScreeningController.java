package com.cinemamanagementsoftware.applicationservice.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/screenings")
public class ScreeningController {
    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;

    public ScreeningController(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper) {
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
    }

    @GetMapping
    public String getAllScreenings() {
        Object response = rabbitTemplate.convertSendAndReceive("screening.fetch.all", "");
        return response != null ? response.toString() : "{\"status\":\"error\",\"message\":\"Failed to fetch screenings\"}";
    }

    @GetMapping("/{id}")
    public String getScreening(@PathVariable("id") Long id) {
        Object response = rabbitTemplate.convertSendAndReceive("screening.fetch", id);
        return response != null ? response.toString() : "{\"status\":\"error\",\"message\":\"Screening not found\"}";
    }
    
    @GetMapping("/hall/{hallId}")
    public String getScreeningsByHall(@PathVariable("hallId") Long hallId) {
        try {
            String response = (String) rabbitTemplate.convertSendAndReceive("screening.fetch.byHall", hallId);
            return response != null ? response : "{\"status\":\"error\",\"message\":\"No screenings found\"}";
        } catch (Exception e) {
            return "{\"status\":\"error\",\"message\":\"Failed to fetch screenings for hall\"}";
        }
    }

    @GetMapping("/movie/{movieId}")
    public String getScreeningsByMovie(@PathVariable("movieId") Long movieId) {
        try {
            String response = (String) rabbitTemplate.convertSendAndReceive("screening.fetch.byMovie", movieId);
            return response != null ? response : "{\"status\":\"error\",\"message\":\"No screenings found\"}";
        } catch (Exception e) {
            return "{\"status\":\"error\",\"message\":\"Failed to fetch screenings for movie\"}";
        }
    }

    @PostMapping
    public String createScreening(@RequestBody Map<String, Object> screeningData) {
        Object response = rabbitTemplate.convertSendAndReceive("screening.create", screeningData);
        return response != null ? response.toString() : "{\"status\":\"error\",\"message\":\"Failed to create screening\"}";
    }

    @PatchMapping("/{id}")
    public String updateScreening(@PathVariable("id") Long id, @RequestBody Map<String, Object> updateData) {
        updateData.put("id", id);
        Object response = rabbitTemplate.convertSendAndReceive("screening.update", updateData);
        return response != null ? response.toString() : "{\"status\":\"error\",\"message\":\"Failed to update screening\"}";
    }

    @DeleteMapping("/{id}")
    public String deleteScreening(@PathVariable("id") Long id) {
        Object response = rabbitTemplate.convertSendAndReceive("screening.delete", id);
        return response != null ? response.toString() : "{\"status\":\"error\",\"message\":\"Failed to delete screening\"}";
    }
}
