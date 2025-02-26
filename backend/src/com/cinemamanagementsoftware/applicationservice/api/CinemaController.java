package com.cinemamanagementsoftware.applicationservice.api;

import cinemaManagementSoftware.impl.CinemaImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cinema")
public class CinemaController {
    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;

    @Autowired
    public CinemaController(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper) {
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
    }

    @PostMapping
    public String createCinema(@RequestBody CinemaImpl cinema) {
        try {
            String json = objectMapper.writeValueAsString(cinema);
            rabbitTemplate.convertAndSend("cinemaExchange", "cinema.create", json);
            return "Cinema creation JSON sent to RabbitMQ!";
        } catch (Exception e) {
            return "Error serializing cinema: " + e.getMessage();
        }
    }
}