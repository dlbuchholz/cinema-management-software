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
        Long hall3Id = createCinemaHall(cinemaId, "Dolby Atmos Hall");
        Long hall4Id = createCinemaHall(cinemaId, "Standard Hall");

        if (hall1Id == null || hall2Id == null || hall3Id == null || hall4Id == null) return;

        // Create Seating Rows for each Hall (each hall gets all row types)
        List<Long> hallIds = List.of(hall1Id, hall2Id, hall3Id, hall4Id);
        List<Long> rowIds = new ArrayList<>();

        for (Long hallId : hallIds) {
            rowIds.add(createSeatingRow(hallId, "Parkett", 1));
            rowIds.add(createSeatingRow(hallId, "Loge", 2));
            rowIds.add(createSeatingRow(hallId, "Loge mit Service", 3));
        }

        if (rowIds.contains(null)) return;

        // Create Seats in each Row
        for (Long rowId : rowIds) {
            createSeats(rowId, 12);
        }

        // Create Movies (Including Star Wars)
        Map<String, Long> movies = new HashMap<>();
        movies.put("Interstellar", createMovie("Interstellar", "Sci-Fi", "A team of explorers travel through a wormhole in space.", 169));
        movies.put("The Dark Knight", createMovie("The Dark Knight", "Action", "Batman faces the Joker in Gotham City.", 152));
        movies.put("Inception", createMovie("Inception", "Thriller", "A thief steals corporate secrets through dream-sharing technology.", 148));
        movies.put("Titanic", createMovie("Titanic", "Romance", "A love story set aboard the ill-fated RMS Titanic.", 195));
        movies.put("Avatar", createMovie("Avatar", "Sci-Fi", "A marine on an alien planet finds himself caught between two worlds.", 162));
        movies.put("The Godfather", createMovie("The Godfather", "Crime", "The aging patriarch of an organized crime dynasty transfers control to his reluctant son.", 175));
        movies.put("Pulp Fiction", createMovie("Pulp Fiction", "Crime", "The lives of two mob hitmen intertwine in unexpected ways.", 154));
        movies.put("The Matrix", createMovie("The Matrix", "Sci-Fi", "A hacker discovers the reality he lives in is an illusion.", 136));
        movies.put("Forrest Gump", createMovie("Forrest Gump", "Drama", "The story of a slow-witted but kind-hearted man through history.", 142));
        movies.put("Star Wars: A New Hope", createMovie("Star Wars: A New Hope", "Sci-Fi", "A young farm boy joins the Rebel Alliance to defeat the evil Empire.", 121));
        movies.put("Star Wars: The Empire Strikes Back", createMovie("Star Wars: The Empire Strikes Back", "Sci-Fi", "Darth Vader pursues the Rebel Alliance while Luke Skywalker trains with Yoda.", 124));
        movies.put("Star Wars: Return of the Jedi", createMovie("Star Wars: Return of the Jedi", "Sci-Fi", "The final battle between the Rebels and the Empire.", 131));
        movies.put("Star Wars: The Phantom Menace", createMovie("Star Wars: The Phantom Menace", "Sci-Fi", "A young Anakin Skywalker is discovered and trained by the Jedi.", 136));
        movies.put("Star Wars: Attack of the Clones", createMovie("Star Wars: Attack of the Clones", "Sci-Fi", "The Clone Wars begin as Anakin falls in love with Padmé.", 142));
        movies.put("Star Wars: Revenge of the Sith", createMovie("Star Wars: Revenge of the Sith", "Sci-Fi", "Anakin Skywalker turns to the dark side and becomes Darth Vader.", 140));
        movies.put("Star Wars: The Force Awakens", createMovie("Star Wars: The Force Awakens", "Sci-Fi", "A new hero rises as the First Order threatens the galaxy.", 138));
        movies.put("Star Wars: The Last Jedi", createMovie("Star Wars: The Last Jedi", "Sci-Fi", "Rey seeks Luke Skywalker's guidance while the Resistance fights the First Order.", 152));
        movies.put("Star Wars: The Rise of Skywalker", createMovie("Star Wars: The Rise of Skywalker", "Sci-Fi", "The Resistance faces the Final Order in the ultimate battle.", 142));

        // Remove null movies
        movies.values().removeIf(Objects::isNull);

        // Create Screenings
        List<String> screeningDates = List.of("2025-03-10", "2025-03-11", "2025-03-12", "2025-03-13", "2025-03-14");

        for (Map.Entry<String, Long> movieEntry : movies.entrySet()) {
            for (int i = 0; i < hallIds.size(); i++) {
                createScreening(movieEntry.getValue(), hallIds.get(i), screeningDates.get(i % screeningDates.size()), 17.00 + (i * 1.5), 20.00 + (i * 1.5));
            }
        }
    }
    
    private void createCategory(String name) {
        try {
            String response = (String) rabbitTemplate.convertSendAndReceive("category.create", Map.of("name", name));
            //System.out.println("📌 Category: " + name + " → " + response);
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
            
            if (response.contains("id")) {
                //System.out.println("🎬 Cinema created: " + name);
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
                //System.out.println("🏛️ Cinema Hall created: " + hallName);
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
                //System.out.println("🪑 Seating Row created: " + categoryName + " - Row " + rowNumber);
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
                    //System.out.println("🎟️ Seat created: #" + i);
                }
            } catch (Exception e) {
                System.err.println("❌ Error creating seat: " + e.getMessage());
            }
        }
    }
    
    private Long createMovie(String title, String genre, String description, double length) {
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
            	return Long.valueOf(responseMap.get("id").toString());
            }
        } catch (Exception e) {
            System.err.println("❌ Error creating movie: " + e.getMessage());
        }
        return null;
    }
    
    private Long createScreening(Long movieId, Long hallId, String date, double startTime, double endTime) {
        try {
            Map<String, Object> screeningData = Map.of(
                "movieId", movieId,
                "cinemaHallId", hallId,
                "date", date,
                "startTime", startTime,
                "endTime", endTime
            );
            String response = (String) rabbitTemplate.convertSendAndReceive("screening.create", screeningData);
            Map<String, Object> responseMap = objectMapper.readValue(response, Map.class);

            if (response.contains("id")) {
                return Long.valueOf(responseMap.get("id").toString());
            }
        } catch (Exception e) {
            System.err.println("❌ Error creating screening: " + e.getMessage());
        }
        return null;
    }
}