package com.cinemamanagementsoftware;

import com.cinemamanagementsoftware.database.CinemaService;
import com.cinemamanagementsoftware.database.DatabaseController;
import com.cinemamanagementsoftware.database.GraphDatabaseController;
import cinemaManagementSoftware.Cinema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        // Start Spring Boot application
    	ApplicationContext context = SpringApplication.run(Main.class, args);

        // Initialize database controllers
        DatabaseController mySQLController = new DatabaseController();
        GraphDatabaseController neo4jController = new GraphDatabaseController();

        // Initialize services
        CinemaService cinemaService = context.getBean(CinemaService.class);

        // Try to load an existing cinema, otherwise create a new one
        Cinema cinema = cinemaService.getCinemaById(1L);
        if (cinema == null) {
        	cinema = cinemaService.createCinema("CineMega ABC", "Hannover");
            System.out.println("🎬 New cinema created: " + cinema.getName());
        } else {
            System.out.println("✅ Cinema data successfully loaded from MySQL!");
        }

        // Start Interactive Console
        ConsoleInterface console = new ConsoleInterface(cinemaService, cinema, mySQLController, neo4jController);
        console.start();
    }
}
