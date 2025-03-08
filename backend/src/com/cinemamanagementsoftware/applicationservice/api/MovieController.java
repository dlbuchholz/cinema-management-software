package com.cinemamanagementsoftware.applicationservice.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import cinemaManagementSoftware.Movie;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;

    public MovieController(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper) {
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
    }
    
    @GetMapping("/search")
    public Object searchMovies(@RequestParam String query) {
        if (query == null || query.trim().isEmpty()) {
            return "{\"status\":\"error\",\"message\":\"Search query cannot be empty!\"}";
        }

        Object response = rabbitTemplate.convertSendAndReceive("movie.search", query.trim());
        return Objects.requireNonNullElse(response, "{\"status\":\"error\",\"message\":\"No movies found\"}");
    }

    // Get all movies
    @GetMapping
    public Object getAllMovies() {
        Object response = rabbitTemplate.convertSendAndReceive("movie.fetch.all", "");
        return Objects.requireNonNullElse(response, "{\"status\":\"error\",\"message\":\"No movies found\"}");
    }

    // Get a specific movie by ID
    @GetMapping("/{id}")
    public Object getMovieById(@PathVariable("id") Long id) {
        Object response = rabbitTemplate.convertSendAndReceive("movie.fetch", id);
        return Objects.requireNonNullElse(response, "{\"status\":\"error\",\"message\":\"Movie not found\"}");
    }

    // Create a new movie with Ecore validation
    @PostMapping
    public Object createMovie(@RequestBody String jsonMovie) {
        try {
            // Ensure "eClass" exists
            String validatedJson = APIUtils.ensureEClassField(jsonMovie, "http://www.example.org/cinemaManagementSoftware#//Movie");

            // Try to construct a Movie Ecore instance
            Movie movie = objectMapper.readValue(validatedJson, Movie.class);
            if (movie == null || movie.getTitle() == null || movie.getDescription() == null|| movie.getGenre() == null) {
                return "{\"status\":\"error\",\"message\":\"Movie entity is missing required fields!\"}";
            }
            
            //Serialize again before sending to RabbitMQ
            String json = objectMapper.writeValueAsString(Collections.singletonMap("movie", movie));
            String jsonResponse = (String) rabbitTemplate.convertSendAndReceive("movie.create", json);
            return jsonResponse;
        } catch (Exception e) {
            return "{\"status\":\"error\",\"message\":\"Error processing movie creation: " + e.getMessage() + "\"}";
        }
    }

    // Update an existing movie
    @PatchMapping("/{id}")
    public Object updateMovie(@PathVariable Long id, @RequestBody Map<String, String> movieData) {
        movieData.put("id", String.valueOf(id));
        Object response = rabbitTemplate.convertSendAndReceive("movie.update", movieData);
        return Objects.requireNonNullElse(response, "{\"status\":\"error\",\"message\":\"Movie update failed\"}");
    }

    // Delete a movie
    @DeleteMapping("/{id}")
    public Object deleteMovie(@PathVariable Long id) {
        Object response = rabbitTemplate.convertSendAndReceive("movie.delete", id);
        return Objects.requireNonNullElse(response, "{\"status\":\"error\",\"message\":\"Movie deletion failed\"}");
    }
}