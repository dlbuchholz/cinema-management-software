package com.cinemamanagementsoftware.persistenceservice.consumers;

import com.cinemamanagementsoftware.persistenceservice.entities.MovieEntity;
import com.cinemamanagementsoftware.persistenceservice.repositories.MovieRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class MovieCommandConsumer {

    private final MovieRepository movieRepository;
    private final ObjectMapper objectMapper;
    private final RabbitTemplate rabbitTemplate;

    public MovieCommandConsumer(MovieRepository movieRepository, ObjectMapper objectMapper, RabbitTemplate rabbitTemplate) {
        this.movieRepository = movieRepository;
        this.objectMapper = objectMapper;
        this.rabbitTemplate = rabbitTemplate;
    }
    
    @RabbitListener(queues = "movie.search")
    public String searchMovies(String query) {
        try {
            List<MovieEntity> matchingMovies = movieRepository.findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCaseOrGenreContainingIgnoreCase(query, query, query);

            if (matchingMovies.isEmpty()) {
                return "{\"status\":\"error\",\"message\":\"No movies found\"}";
            }

            return objectMapper.writeValueAsString(matchingMovies);
        } catch (Exception e) {
            return "{\"status\":\"error\",\"message\":\"Error processing movie search\"}";
        }
    }

    // Fetch all movies
    @RabbitListener(queues = "movie.fetch.all")
    public String fetchAllMovies() {
        try {
            List<MovieEntity> movies = movieRepository.findAll();
            return objectMapper.writeValueAsString(movies);
        } catch (Exception e) {
            return "{\"status\":\"error\",\"message\":\"Failed to fetch movies\"}";
        }
    }

    // Fetch a movie by ID
    @RabbitListener(queues = "movie.fetch")
    public String fetchMovie(Long id) {
        try {
            Optional<MovieEntity> movie = movieRepository.findById(id);
            return movie.map(m -> {
                try {
                    return objectMapper.writeValueAsString(m);
                } catch (Exception e) {
                    return "{\"status\":\"error\",\"message\":\"Failed to serialize movie\"}";
                }
            }).orElse("{\"status\":\"error\",\"message\":\"Movie not found\"}");
        } catch (Exception e) {
            return "{\"status\":\"error\",\"message\":\"Failed to fetch movie:" + e.toString() + " \"}";
        }
    }
    
    @RabbitListener(queues = "movie.create")
    public String createMovie(String movieJson) {
        try {
            // Extract and deserialize JSON
            String extractedJson = extractNestedJson(movieJson, "movie");
            MovieEntity cinema = objectMapper.readValue(extractedJson, MovieEntity.class);
            MovieEntity savedMovie = movieRepository.save(cinema);
            rabbitTemplate.convertAndSend("event.movie.created", Map.of(
                    "movieId", savedMovie.getId(),
                    "title", savedMovie.getTitle(),
                    "genre", savedMovie.getGenre(),
                    "description", savedMovie.getDescription(),
                    "length", savedMovie.getLength()
                ));
            return objectMapper.writeValueAsString(savedMovie);

        } catch (Exception e) {
            System.err.println("❌ Error creating MovieEntity: " + e.getMessage());
            return "{\"status\":\"error\",\"message\":\"Movie creation failed\"}";
        }
    }

    // Update an existing movie
    @RabbitListener(queues = "movie.update")
    public String updateMovie(Map<String, String> movieData) {
        try {
            Long id = Long.parseLong(movieData.get("id"));
            Optional<MovieEntity> movieOptional = movieRepository.findById(id);

            if (movieOptional.isEmpty()) {
                return "{\"status\":\"error\",\"message\":\"Movie not found\"}";
            }

            MovieEntity movie = movieOptional.get();
            if (movieData.containsKey("title")) {
                movie.setTitle(movieData.get("title"));
            }
            if (movieData.containsKey("description")) {
                movie.setDescription(movieData.get("description"));
            }

            movieRepository.save(movie);
            return "{\"status\":\"success\",\"message\":\"Movie updated\"}";
        } catch (Exception e) {
            return "{\"status\":\"error\",\"message\":\"Movie update failed\"}";
        }
    }

    // Delete a movie
    @RabbitListener(queues = "movie.delete")
    public String deleteMovie(Long id) {
        try {
            movieRepository.deleteById(id);
            return "{\"status\":\"success\",\"message\":\"Movie deleted\"}";
        } catch (Exception e) {
            return "{\"status\":\"error\",\"message\":\"Movie deletion failed\"}";
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