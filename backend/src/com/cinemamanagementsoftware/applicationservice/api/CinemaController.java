package com.cinemamanagementsoftware.applicationservice.api;

import cinemaManagementSoftware.Cinema;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cinemas")
public class CinemaController {
    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;

    @Autowired
    public CinemaController(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper) {
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
    }

    @PostMapping
    public String createCinema(@RequestBody Cinema cinema) {
        try {
            String json = objectMapper.writeValueAsString(cinema);
            rabbitTemplate.convertAndSend("cinemaExchange", "cinema.create", json);
            return "Cinema JSON sent to RabbitMQ!";
        } catch (Exception e) {
            return "Error serializing cinema: " + e.getMessage();
        }
    }
    
    @GetMapping
    public String fetchCinema() {
        try {
            String jsonResponse = (String) rabbitTemplate.convertSendAndReceive("cinemaExchange", "cinema.fetch", "");
            System.out.println(jsonResponse);
            if (jsonResponse != null && !jsonResponse.isEmpty()) {
                return jsonResponse;
            } else {
                return "❌ No cinema found.";
            }
        } catch (Exception e) {
            return "❌ Error fetching cinema: " + e.getMessage();
        }
    }

    @PatchMapping("/{id}")
    public String updateCinema(@PathVariable Long id, @RequestBody Cinema cinema) {
        try {
            cinema.setId(id); // Ensure ID is set
            String json = objectMapper.writeValueAsString(cinema);
            rabbitTemplate.convertAndSend("cinemaExchange", "cinema.update", json);
            return "Cinema update request sent!";
        } catch (Exception e) {
            return "Error serializing cinema update: " + e.getMessage();
        }
    }

    @DeleteMapping("/{id}")
    public String deleteCinema(@PathVariable Long id) {
        rabbitTemplate.convertAndSend("cinemaExchange", "cinema.delete", id);
        return "Cinema delete request sent!";
    }
}