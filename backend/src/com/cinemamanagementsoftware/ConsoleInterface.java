package com.cinemamanagementsoftware;

import com.cinemamanagementsoftware.database.CinemaService;
import com.cinemamanagementsoftware.database.DatabaseController;
import com.cinemamanagementsoftware.database.GraphDatabaseController;
import cinemaManagementSoftware.Cinema;

import java.util.Scanner;

public class ConsoleInterface {
    private final CinemaService cinemaService;
    private final Cinema cinema;
    private final DatabaseController dbController;
    private final GraphDatabaseController graphDbController;
    private final Scanner scanner;

    public ConsoleInterface(CinemaService cinemaService, Cinema cinema, 
                            DatabaseController dbController, 
                            GraphDatabaseController graphDbController) {
        this.cinemaService = cinemaService;
        this.cinema = cinema;
        this.scanner = new Scanner(System.in);
        this.dbController = dbController;
        this.graphDbController = graphDbController;
    }

    public void start() {
        System.out.println("🎬 Welcome to " + cinema.getName() + " Management System!");
        System.out.println("Type `/help` for available commands.");

        boolean running = true;
        while (running) {
            System.out.print("\n> ");  // User prompt
            String input = scanner.nextLine().trim();

            if (input.startsWith("/")) {
                running = handleCommand(input);
            } else {
                System.out.println("⚠ Unknown command. Type `/help` for a list of commands.");
            }
        }

        scanner.close();
        System.out.println("Exiting... Goodbye! 🎬");
    }

    private boolean handleCommand(String input) {
        switch (input) {
            case "/exit":
                return false;

            case "/help":
                System.out.println("\nAvailable Commands:");
                System.out.println("/help    - Show this help menu");
                System.out.println("/info    - Show cinema details");
                System.out.println("/rename  - Change cinema name");
                System.out.println("/location - Change cinema location");
                System.out.println("/stats   - Show cinema statistics from Neo4J");
                System.out.println("/exit    - Quit the program");
                break;

            case "/info":
                System.out.println("\n🎥 Cinema Info:");
                System.out.println("Name: " + cinema.getName());
                System.out.println("Location: " + cinema.getLocation());
                break;

            case "/rename":
                System.out.print("Enter new cinema name: ");
                String newName = scanner.nextLine().trim();
                cinema.setName(newName);
                cinemaService.save(cinema);
                System.out.println("✅ Cinema name updated to: " + newName);
                break;

            case "/location":
                System.out.print("Enter new cinema location: ");
                String newLocation = scanner.nextLine().trim();
                cinema.setLocation(newLocation);
                cinemaService.save(cinema);
                System.out.println("✅ Cinema location updated to: " + newLocation);
                break;

            case "/stats":
                System.out.println("📊 Fetching statistics...");
                graphDbController.executeQuery("MATCH (c:CinemaStatistics) RETURN c");
                break;

            default:
                System.out.println("⚠ Unknown command. Type `/help` for a list of commands.");
        }
        return true;
    }
}
