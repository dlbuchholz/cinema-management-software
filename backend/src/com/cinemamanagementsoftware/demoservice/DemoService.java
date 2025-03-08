package com.cinemamanagementsoftware.demoservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.springframework.context.event.EventListener;
import org.springframework.boot.context.event.ApplicationReadyEvent;

import java.util.*;

@Service
public class DemoService {

    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;

    public DemoService(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper) {
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void populateDemoData() {
        System.out.println("🚀 Populating demo data...");
        
        // Create Default Categories
        createCategory("Parkett");
        createCategory("Loge");
        createCategory("Loge mit Service");

        // Create Cinema
        Long cinemaId = createCinema("CineMega ABC", "Hannover");
        if (cinemaId == null) return;

        // Create Cinema Halls
        Long hall1Id = createCinemaHall(cinemaId, "IMAX Hall");
        Long hall2Id = createCinemaHall(cinemaId, "VIP Lounge");

        if (hall1Id == null || hall2Id == null) return;

        // Create Seating Rows for each Hall
        Long row1Id = createSeatingRow(hall1Id, "Parkett", 1);
        Long row2Id = createSeatingRow(hall1Id, "Loge", 2);
        Long row3Id = createSeatingRow(hall2Id, "Loge mit Service", 1);

        if (row1Id == null || row2Id == null || row3Id == null) return;

        // Create Seats in the Rows
        createSeats(row1Id, 10);
        createSeats(row2Id, 8);
        createSeats(row3Id, 5);
        
     // Create Movies
        createMovie("Interstellar", "Sci-Fi", "A team of explorers travel through a wormhole in space.", 169);
        createMovie("The Dark Knight", "Action", "Batman faces the Joker in Gotham City.", 152);
        createMovie("Inception", "Thriller", "A thief steals corporate secrets through dream-sharing technology.", 148);
        createMovie("Titanic", "Romance", "A love story set aboard the ill-fated RMS Titanic.", 195);

        System.out.println("Demo data setup complete!");
    }
    
    private void createCategory(String name) {
        try {
            String response = (String) rabbitTemplate.convertSendAndReceive("category.create", Map.of("name", name));
            System.out.println("📌 Category: " + name + " → " + response);
        } catch (Exception e) {
            System.err.println("❌ Failed to create category " + name + ": " + e.getMessage());
        }
    }

    // Create a Cinema
    private Long createCinema(String name, String location) {
        try {
            Map<String, String> cinemaData = new HashMap<>();
            cinemaData.put("name", name);
            cinemaData.put("location", location);
            String cinemaJson = objectMapper.writeValueAsString(cinemaData);

            String response = (String) rabbitTemplate.convertSendAndReceive("cinema.create", cinemaJson);
            Map<String, Object> responseMap = objectMapper.readValue(response, Map.class);
            
            System.out.println(response);
            
            if (response.contains("id")) {
                System.out.println("🎬 Cinema created: " + name);
                return Long.valueOf(responseMap.get("id").toString());
            }
        } catch (Exception e) {
            System.err.println("❌ Error creating cinema: " + e.getMessage());
        }
        return null;
    }

    // Create a Cinema Hall
    private Long createCinemaHall(Long cinemaId, String hallName) {
        try {
            Map<String, Object> hallData = new HashMap<>();
            hallData.put("cinemaId", cinemaId);
            hallData.put("name", hallName);

            String response = (String) rabbitTemplate.convertSendAndReceive("cinemaHall.create", hallData);
            Map<String, Object> responseMap = objectMapper.readValue(response, Map.class);

            if (response.contains("id")) {
                System.out.println("🏛️ Cinema Hall created: " + hallName);
                return Long.valueOf(responseMap.get("id").toString());
            } else {
            	System.out.println(response);
            }
        } catch (Exception e) {
            System.err.println("❌ Error creating cinema hall: " + e.getMessage());
        }
        return null;
    }

    // Create a Seating Row
    private Long createSeatingRow(Long hallId, String categoryName, int rowNumber) {
        try {
            Map<String, Object> rowData = new HashMap<>();
            rowData.put("cinemaHallId", hallId);
            rowData.put("category", categoryName);
            rowData.put("nr", rowNumber);

            String response = (String) rabbitTemplate.convertSendAndReceive("seatingRow.create", rowData);
            Map<String, Object> responseMap = objectMapper.readValue(response, Map.class);

            if (response.contains("id")) {
                System.out.println("🪑 Seating Row created: " + categoryName + " - Row " + rowNumber);
                return Long.valueOf(responseMap.get("id").toString());
            }
        } catch (Exception e) {
            System.err.println("❌ Error creating seating row: " + e.getMessage());
        }
        return null;
    }

    // Create Seats in a Row
    private void createSeats(Long rowId, int seatCount) {
        for (int i = 1; i <= seatCount; i++) {
            try {
                Map<String, Object> seatData = new HashMap<>();
                seatData.put("rowId", rowId);
                seatData.put("seatNumber", i);

                String response = (String) rabbitTemplate.convertSendAndReceive("seat.create", seatData);
                Map<String, Object> responseMap = objectMapper.readValue(response, Map.class);

                if (response.contains("id")) {
                    System.out.println("🎟️ Seat created: #" + i);
                }
            } catch (Exception e) {
                System.err.println("❌ Error creating seat: " + e.getMessage());
            }
        }
    }
    
    private void createMovie(String title, String genre, String description, double length) {
        try {
            Map<String, Object> movieData = new HashMap<>();
            movieData.put("title", title);
            movieData.put("genre", genre);
            movieData.put("description", description);
            movieData.put("length", length);
            String movieJson = objectMapper.writeValueAsString(movieData);

            String response = (String) rabbitTemplate.convertSendAndReceive("movie.create", movieJson);
            Map<String, Object> responseMap = objectMapper.readValue(response, Map.class);

            if (response.contains("id")) {
                System.out.println("🎬 Movie created: " + title);
            }
        } catch (Exception e) {
            System.err.println("❌ Error creating movie: " + e.getMessage());
        }
    }
}