package com.cinemamanagementsoftware.persistenceservice.consumers;

import com.cinemamanagementsoftware.persistenceservice.entities.CinemaHallEntity;
import com.cinemamanagementsoftware.persistenceservice.entities.MovieEntity;
import com.cinemamanagementsoftware.persistenceservice.entities.ScreeningEntity;
import com.cinemamanagementsoftware.persistenceservice.repositories.CinemaHallRepository;
import com.cinemamanagementsoftware.persistenceservice.repositories.MovieRepository;
import com.cinemamanagementsoftware.persistenceservice.repositories.ScreeningRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ScreeningCommandConsumer {

    private final ScreeningRepository screeningRepository;
    private final MovieRepository movieRepository;
    private final CinemaHallRepository cinemaHallRepository;
    private final ObjectMapper objectMapper;
    private final RabbitTemplate rabbitTemplate;

    public ScreeningCommandConsumer(ScreeningRepository screeningRepository,
                                    MovieRepository movieRepository,
                                    CinemaHallRepository cinemaHallRepository,
                                    RabbitTemplate rabbitTemplate,
                                    ObjectMapper objectMapper) {
        this.screeningRepository = screeningRepository;
        this.movieRepository = movieRepository;
        this.cinemaHallRepository = cinemaHallRepository;
        this.objectMapper = objectMapper;
        this.rabbitTemplate = rabbitTemplate;
    }

    // Fetch all screenings
    @RabbitListener(queues = "screening.fetch.all")
    public String fetchAllScreenings() {
        try {
            List<ScreeningEntity> screenings = screeningRepository.findAll();
            return objectMapper.writeValueAsString(screenings);
        } catch (Exception e) {
            return "{\"status\":\"error\",\"message\":\"Failed to fetch screenings\"}";
        }
    }

    // Fetch a screening by ID
    @RabbitListener(queues = "screening.fetch")
    public String fetchScreening(Long id) {
        try {
            Optional<ScreeningEntity> screening = screeningRepository.findById(id);
            return screening.map(s -> {
                try {
                    return objectMapper.writeValueAsString(s);
                } catch (Exception e) {
                    return "{\"status\":\"error\",\"message\":\"Failed to serialize screening\"}";
                }
            }).orElse("{\"status\":\"error\",\"message\":\"Screening not found\"}");
        } catch (Exception e) {
            return "{\"status\":\"error\",\"message\":\"Failed to fetch screening\"}";
        }
    }
    
    @RabbitListener(queues = "screening.fetch.byHall")
    public String fetchScreeningsByHall(Long hallId) {
        try {
            List<ScreeningEntity> screenings = screeningRepository.findByCinemaHallId(hallId);
            return objectMapper.writeValueAsString(screenings);
        } catch (Exception e) {
            return "{\"status\":\"error\",\"message\":\"Failed to fetch screenings for hall\"}";
        }
    }

    @RabbitListener(queues = "screening.fetch.byMovie")
    public String fetchScreeningsByMovie(Long movieId) {
        try {
            List<ScreeningEntity> screenings = screeningRepository.findByMovieId(movieId);
            return objectMapper.writeValueAsString(screenings);
        } catch (Exception e) {
            return "{\"status\":\"error\",\"message\":\"Failed to fetch screenings for movie\"}";
        }
    }
    
    // Create a screening
    @RabbitListener(queues = "screening.create")
    public String createScreening(Map<String, Object> requestData) {
        try {
            if (!requestData.containsKey("movieId") || !requestData.containsKey("cinemaHallId")
                || !requestData.containsKey("date") || !requestData.containsKey("startTime")
                || !requestData.containsKey("endTime")) {
                return "{\"status\":\"error\",\"message\":\"Missing required fields\"}";
            }

            Long movieId = Long.parseLong(requestData.get("movieId").toString());
            Long hallId = Long.parseLong(requestData.get("cinemaHallId").toString());

            Optional<MovieEntity> movieOpt = movieRepository.findById(movieId);
            Optional<CinemaHallEntity> hallOpt = cinemaHallRepository.findById(hallId);

            if (movieOpt.isEmpty()) {
                return "{\"status\":\"error\",\"message\":\"Movie not found\"}";
            }
            if (hallOpt.isEmpty()) {
                return "{\"status\":\"error\",\"message\":\"Cinema hall not found\"}";
            }

            // Handle date conversion (supports both formats)
            Date screeningDate;
            Object dateObject = requestData.get("date");
            if (dateObject instanceof String) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                screeningDate = dateFormat.parse(dateObject.toString());
            } else if (dateObject instanceof Number) {
                screeningDate = new Date(Long.parseLong(dateObject.toString())); // Milliseconds since epoch
            } else {
                return "{\"status\":\"error\",\"message\":\"Invalid date format\"}";
            }

            double startTime = Double.parseDouble(requestData.get("startTime").toString());
            double endTime = Double.parseDouble(requestData.get("endTime").toString());

            ScreeningEntity newScreening = new ScreeningEntity(movieOpt.get(), hallOpt.get(), screeningDate, startTime, endTime);
            screeningRepository.save(newScreening);
            
            // Publish event to RabbitMQ
            Map<String, Object> eventPayload = new HashMap<>();
            eventPayload.put("id", newScreening.getId());
            eventPayload.put("movieId", movieId);
            eventPayload.put("cinemaHallId", hallId);
            eventPayload.put("date", screeningDate);
            eventPayload.put("startTime", startTime);
            eventPayload.put("endTime", endTime);

            rabbitTemplate.convertAndSend("event.screening.created", eventPayload);

            return objectMapper.writeValueAsString(newScreening);
        } catch (Exception e) {
            return "{\"status\":\"error\",\"message\":\"Failed to create Screening: " + e.getMessage() + "\"}";
        }
    }

    // Update a screening
    @RabbitListener(queues = "screening.update")
    public String updateScreening(Map<String, Object> updateData) {
        try {
            if (!updateData.containsKey("id")) {
                return "{\"status\":\"error\",\"message\":\"Missing required field: 'id'\"}";
            }

            Long screeningId = Long.parseLong(updateData.get("id").toString());
            Optional<ScreeningEntity> screeningOpt = screeningRepository.findById(screeningId);

            if (screeningOpt.isEmpty()) {
                return "{\"status\":\"error\",\"message\":\"Screening not found\"}";
            }

            ScreeningEntity screening = screeningOpt.get();

            // Update Movie (if provided)
            if (updateData.containsKey("movieId")) {
                Long movieId = Long.parseLong(updateData.get("movieId").toString());
                Optional<MovieEntity> movieOpt = movieRepository.findById(movieId);
                if (movieOpt.isEmpty()) {
                    return "{\"status\":\"error\",\"message\":\"Movie not found\"}";
                }
                screening.setMovie(movieOpt.get());
            }

            // Update Cinema Hall (if provided)
            if (updateData.containsKey("cinemaHallId")) {
                Long hallId = Long.parseLong(updateData.get("cinemaHallId").toString());
                Optional<CinemaHallEntity> hallOpt = cinemaHallRepository.findById(hallId);
                if (hallOpt.isEmpty()) {
                    return "{\"status\":\"error\",\"message\":\"Cinema hall not found\"}";
                }
                screening.setCinemaHall(hallOpt.get());
            }

            // Handle date parsing
            if (updateData.containsKey("date")) {
                Object dateObject = updateData.get("date");
                Date screeningDate;
                if (dateObject instanceof String) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    screeningDate = dateFormat.parse(dateObject.toString());
                } else if (dateObject instanceof Number) {
                    screeningDate = new Date(Long.parseLong(dateObject.toString())); // Convert timestamp to Date
                } else {
                    return "{\"status\":\"error\",\"message\":\"Invalid date format\"}";
                }
                screening.setDate(screeningDate);
            }

            // Update start and end time
            if (updateData.containsKey("startTime")) {
                screening.setStartTime(Double.parseDouble(updateData.get("startTime").toString()));
            }
            if (updateData.containsKey("endTime")) {
                screening.setEndTime(Double.parseDouble(updateData.get("endTime").toString()));
            }

            screeningRepository.save(screening);
            return objectMapper.writeValueAsString(screening);

        } catch (Exception e) {
            return "{\"status\":\"error\",\"message\":\"Failed to update Screening: " + e.getMessage() + "\"}";
        }
    }

    // Delete a screening
    @RabbitListener(queues = "screening.delete")
    public String deleteScreening(Long id) {
        try {
            screeningRepository.deleteById(id);
            return "{\"status\":\"success\",\"message\":\"Screening deleted successfully\"}";
        } catch (Exception e) {
            return "{\"status\":\"error\",\"message\":\"Failed to delete Screening\"}";
        }
    }
}