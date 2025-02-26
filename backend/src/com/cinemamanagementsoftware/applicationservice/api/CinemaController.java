package com.cinemamanagementsoftware.applicationservice.api;

import cinemaManagementSoftware.Cinema;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Collections;
import org.eclipse.emfcloud.jackson.module.EMFModule;
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
        
        this.objectMapper.registerModule(new EMFModule());
    }

    @PostMapping
    public String createCinema(@RequestBody String jsonCinema) {
        try {
            Cinema cinema = objectMapper.readValue(ensureEClassField(jsonCinema), Cinema.class);
            
            if(cinema == null) {
            	return "{}";
            }
            // ✅ Serialize again before sending to RabbitMQ
            String json = objectMapper.writeValueAsString(Collections.singletonMap("cinema", cinema));
            String jsonResponse = (String) rabbitTemplate.convertSendAndReceive("cinemaExchange", "cinema.create", json);
            return jsonResponse;
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
    
    private String ensureEClassField(String jsonCinema) throws Exception {
        JsonNode jsonNode = objectMapper.readTree(jsonCinema);

        // ✅ Ensure the "eClass" field exists
        if (!jsonNode.has("eClass")) {
            ((ObjectNode) jsonNode).put("eClass", "http://www.example.org/cinemaManagementSoftware#//Cinema");
        }

        return objectMapper.writeValueAsString(jsonNode);
    }
}