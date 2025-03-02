package com.cinemamanagementsoftware.authenticationservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class AuthenticationService {
    
    private final JwtUtil jwtUtil;
    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;
	private final PasswordEncoder passwordEncoder;
    
    public AuthenticationService(JwtUtil jwtUtil, RabbitTemplate rabbitTemplate, ObjectMapper objectMapper, PasswordEncoder passwordEncoder) {
        this.jwtUtil = jwtUtil;
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @RabbitListener(queues = "auth.register")
    public String register(Map<String, String> request) {
        String email = request.get("email");
        String name = request.get("name");
        String password = request.get("password");
        String telephone = request.get("telephone");

        // Synchronously fetch existing user from customer service
        String existingUserJson = (String) rabbitTemplate.convertSendAndReceive("customer.fetch", email);
        if (existingUserJson != null && !existingUserJson.trim().isEmpty() && !existingUserJson.equals("{}")) {
            return "{\"status\":\"error\", \"message\":\"User already exists!\"}";
        }

        // Encode the password using PasswordEncoder
        String hashedPassword = passwordEncoder.encode(password);

        // Prepare new user payload with the hashed password
        Map<String, String> newUser = new HashMap<>();
        newUser.put("email", email);
        newUser.put("name", name);
        newUser.put("password", hashedPassword);
        newUser.put("telephone", telephone);
        
        // Asynchronously send user creation request (no reply expected)
        rabbitTemplate.convertAndSend("customer.create", newUser);

        // Generate JWT and return success JSON
        String token = jwtUtil.generateToken(email);
        return "{\"status\":\"success\", \"token\":\"" + token + "\"}";
    }

    @RabbitListener(queues = "auth.login")
    public String login(Map<String, String> request) {
        String email = request.get("email");
        String password = request.get("password");

        // Synchronously fetch user from customer service
        String userJson = (String) rabbitTemplate.convertSendAndReceive("customer.fetch", email);
        if (userJson == null || userJson.trim().isEmpty() || userJson.equals("{}")) {
            return "{\"status\":\"error\", \"message\":\"Invalid credentials!\"}";
        }
        try {
            // Convert the JSON string to a Map
            Map<String, String> user = objectMapper.readValue(userJson, Map.class);
            String storedPassword = user.get("password");
            // Compare raw password with the stored hashed password using PasswordEncoder
            if (!passwordEncoder.matches(password, storedPassword)) {
                return "{\"status\":\"error\", \"message\":\"Invalid credentials!\"}";
            }
            // Generate JWT token on successful authentication
            String token = jwtUtil.generateToken(email);
            return "{\"status\":\"success\", \"token\":\"" + token + "\"}";
        } catch (Exception e) {
            return "{\"status\":\"error\", \"message\":\"Error processing login: " + e.getMessage() + "\"}";
        }
    }

    @RabbitListener(queues = "auth.validateToken")
    public String validateToken(Map<String, String> request) {
        try {
            // Log the incoming request for debugging (remove or adjust logging in production)
            System.out.println("validateToken called with request: " + request);
            
            String token = request.get("token");
            if (token == null || token.trim().isEmpty()) {
                return "{\"status\":\"error\", \"message\":\"Token not provided\"}";
            }
            boolean isValid = jwtUtil.validateToken(token);
            return isValid 
                    ? "{\"status\":\"success\", \"message\":\"Token is valid\"}"
                    : "{\"status\":\"error\", \"message\":\"Invalid token\"}";
        } catch (Exception e) {
            // Log exception details for debugging
            System.err.println("Error in validateToken: " + e.getMessage());
            return "{\"status\":\"error\", \"message\":\"Error validating token: " + e.getMessage() + "\"}";
        }
    }
}