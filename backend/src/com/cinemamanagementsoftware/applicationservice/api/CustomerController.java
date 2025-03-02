package com.cinemamanagementsoftware.applicationservice.api;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;

    public CustomerController(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper) {
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<String> getCustomer(@PathVariable("id") Long id) {
        // Get the current authenticated user from the SecurityContext
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return ResponseEntity.status(401)
                    .body("{\"status\":\"error\", \"message\":\"Unauthorized\"}");
        }

        // In our JwtAuthenticationFilter we set the principal to the user's email.
        String email = (String) authentication.getPrincipal();

        // Now send a request to fetch the customer data, for example via RabbitMQ.
        // Here we assume you have a consumer listening on "customer.fetchById" that returns customer details as JSON.
        Object response = rabbitTemplate.convertSendAndReceive("customer.fetchById", id);
        if (response == null) {
            return ResponseEntity.status(404)
                    .body("{\"status\":\"error\", \"message\":\"Customer not found\"}");
        }

        try {
            // Assume the customer JSON has an "email" field. Parse it to enforce that the authenticated user
            // is allowed to access this customer.
            Map<String, Object> customerMap = objectMapper.readValue(response.toString(), Map.class);
            String customerEmail = (String) customerMap.get("email");

            if (!email.equals(customerEmail)) {
                return ResponseEntity.status(403)
                        .body("{\"status\":\"error\", \"message\":\"Access denied\"}");
            }
            // If authorized, return the customer data
            return ResponseEntity.ok(response.toString());
        } catch (Exception e) {
            return ResponseEntity.status(500)
                    .body("{\"status\":\"error\", \"message\":\"Error processing request: " + e.getMessage() + "\"}");
        }
    }
    
    @GetMapping("/me")
    public ResponseEntity<String> getCustomerProfile() {
        // Get the current authenticated user from the SecurityContext
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return ResponseEntity.status(401)
                    .body("{\"status\":\"error\", \"message\":\"Unauthorized\"}");
        }

        // The JwtAuthenticationFilter sets the principal as the user's email
        String email = (String) authentication.getPrincipal();

        // Use email to fetch the customer data using RabbitMQ
        Object response = rabbitTemplate.convertSendAndReceive("customer.fetch", email);
        if (response == null || response.toString().trim().isEmpty() || response.toString().equals("{}")) {
            return ResponseEntity.status(404)
                    .body("{\"status\":\"error\", \"message\":\"Customer not found\"}");
        }

        try {
            // Optionally, validate that the customer record's email matches the token's email.
            Map<String, Object> customerMap = objectMapper.readValue(response.toString(), Map.class);
            String customerEmail = (String) customerMap.get("email");

            if (!email.equals(customerEmail)) {
                return ResponseEntity.status(403)
                        .body("{\"status\":\"error\", \"message\":\"Access denied\"}");
            }
            return ResponseEntity.ok(response.toString());
        } catch (Exception e) {
            return ResponseEntity.status(500)
                    .body("{\"status\":\"error\", \"message\":\"Error processing request: " + e.getMessage() + "\"}");
        }
    }

    @PostMapping("/register")
    public String register(@RequestBody HashMap<String, String> user) {
        try {
            Object response = rabbitTemplate.convertSendAndReceive("auth.register", user);
            if (response == null) {
                return "{\"status\":\"error\",\"message\":\"Timeout\"}";
            }
            return response.toString();
        } catch (Exception e) {
            return "{\"status\":\"error\",\"message\":\"Error processing registration: " + e.getMessage() + "\"}";
        }
    }

    @PostMapping("/login")
    public String login(@RequestBody HashMap<String, String> user) {
        try {
            Object response = rabbitTemplate.convertSendAndReceive("auth.login", user);
            if (response == null) {
                return "{\"status\":\"error\",\"message\":\"Timeout\"}";
            }
            return response.toString();
        } catch (Exception e) {
            return "{\"status\":\"error\",\"message\":\"Error processing login: " + e.getMessage() + "\"}";
        }
    }

    @PostMapping("/validate")
    public String validateToken(@RequestBody HashMap<String, String> request) {
        try {
            Object response = rabbitTemplate.convertSendAndReceive("auth.validateToken", request);
            if (response == null) {
                return "{\"status\":\"error\",\"message\":\"Timeout\"}";
            }
            return response.toString();
        } catch (Exception e) {
            return "{\"status\":\"error\",\"message\":\"Error validating token: " + e.getMessage() + "\"}";
        }
    }
}