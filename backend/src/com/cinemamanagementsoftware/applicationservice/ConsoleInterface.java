package com.cinemamanagementsoftware.applicationservice;

import cinemaManagementSoftware.Cinema;
import cinemaManagementSoftware.CinemaManagementSoftwareFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.emfcloud.jackson.module.EMFModule;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.util.Collections;
import java.util.Scanner;
import java.util.UUID;

public class ConsoleInterface {
    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;
    private Cinema cinema;
    private final Scanner scanner = new Scanner(System.in);

    public ConsoleInterface(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        
        // Setup EMF JSON-Jackson Serializer
        this.objectMapper = new ObjectMapper();
        this.objectMapper.registerModule(new EMFModule());

        fetchOrCreateCinema();
    }

    private void fetchOrCreateCinema() {
        System.out.println("📽️ Fetching cinema data...");

        try {
            // Directly send request and receive response
            String jsonResponse = (String) rabbitTemplate.convertSendAndReceive("cinemaExchange", "cinema.fetch", "");
            
            if (!jsonResponse.contains("error")) {
                // Deserialize JSON into Ecore Cinema
                cinema = objectMapper.readValue(jsonResponse, Cinema.class);
                System.out.println("🎬 Loaded Cinema: " + cinema.getName() + " (" + cinema.getLocation() + ")");
            } else {
                System.out.println("⚠ No existing cinema found.");
                promptCinemaCreation();
            }
        } catch (Exception e) {
            System.err.println("❌ Error fetching cinema data: " + e.getMessage());
            promptCinemaCreation();
        }
    }
    
    private void promptCinemaCreation() {
        System.out.print("Enter Cinema Name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Enter Cinema Location: ");
        String location = scanner.nextLine().trim();
        
        cinema = CinemaManagementSoftwareFactory.eINSTANCE.createCinema();
        cinema.setName(name);
        cinema.setLocation(location);
        createCinema();
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
        System.out.println("👋 Exiting... Goodbye!");
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
                updateCinema();
                break;

            case "/location":
                System.out.print("Enter new cinema location: ");
                String newLocation = scanner.nextLine().trim();
                cinema.setLocation(newLocation);
                updateCinema();
                break;

            case "/stats":
                System.out.println("📊 Fetching statistics...");
                //graphDatabaseController.executeQuery("MATCH (c:CinemaStatistics) RETURN c");
                break;

            default:
                System.out.println("⚠ Unknown command. Type `/help` for a list of commands.");
        }
        return true;
    }

    private void createCinema() {
        try {
            // Serialize Ecore object
            String jsonRequest = objectMapper.writeValueAsString(Collections.singletonMap("cinema", cinema));

            // ✅ Send request and wait for response
            System.out.println("📨 Sending create request and waiting for response...");
            String jsonResponse = (String) rabbitTemplate.convertSendAndReceive("cinemaExchange", "cinema.create", jsonRequest);

            if (jsonResponse != null && !jsonResponse.isEmpty()) {
                cinema = objectMapper.readValue(jsonResponse, Cinema.class);
                System.out.println("✅ Cinema created: " + cinema.getName() + " (ID: " + cinema.getId() + ")");
            } else {
                System.err.println("❌ Error: No response from the create operation.");
            }
        } catch (Exception e) {
            System.err.println("❌ Error creating cinema: " + e.getMessage());
        }
    }
    
    private void fetchCinema() {
        System.out.println("📽️ Fetching newly created cinema...");

        try {
            String jsonResponse = (String) rabbitTemplate.convertSendAndReceive("cinemaExchange", "cinema.fetch", "");

            if (jsonResponse != null && !jsonResponse.isEmpty()) {
                // Deserialize JSON into Ecore Cinema
                cinema = objectMapper.readValue(jsonResponse, Cinema.class);
                System.out.println("🎬 Loaded Cinema: " + cinema.getName() + " (" + cinema.getLocation() + ")");
            } else {
                System.err.println("❌ Unknown error fetching cinema data");
            }
        } catch (Exception e) {
            System.err.println("❌ Error fetching cinema data: " + e.getMessage());

        }
    }

    private void updateCinema() {
        try {
            // Serialize Ecore object
            String jsonRequest = objectMapper.writeValueAsString(Collections.singletonMap("cinema", cinema));
            rabbitTemplate.convertAndSend("cinemaExchange", "cinema.update", jsonRequest);
            System.out.println("✅ Cinema update request sent!");
        } catch (Exception e) {
            System.err.println("❌ Error updating cinema: " + e.getMessage());
        }
    }
}