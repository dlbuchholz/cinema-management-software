package com.cinemamanagementsoftware.authenticationservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.*;

@Service
public class AuthenticationService {
    
    private final JwtUtil jwtUtil;
    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;
    
    public AuthenticationService(JwtUtil jwtUtil, RabbitTemplate rabbitTemplate, ObjectMapper objectMapper) {
        this.jwtUtil = jwtUtil;
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
    }

    @RabbitListener(queues = "auth.register")
    public void register(Map<String, String> request) {
    	String email = request.get("email");
        String name = request.get("name");
        String password = request.get("password");
        String telephone = request.get("telephone");
        String responseQueue = request.get("responseQueue");

        // 🔹 Request existing user from customer service
        String existingUserJson = (String) rabbitTemplate.convertSendAndReceive("customer.fetch", email);

        if (existingUserJson != null && !existingUserJson.isEmpty()) {
            rabbitTemplate.convertAndSend(responseQueue, "❌ User already exists!");
            return;
        }

        // 🔹 Create user payload
        Map<String, String> newUser = new HashMap<>();
        newUser.put("email", email);
        newUser.put("name", name);
        newUser.put("password", password); // Password hashing is handled by persistence service
        newUser.put("telephone", telephone);
        
        // 🔹 Send user creation request
        rabbitTemplate.convertAndSend("customer.create", newUser);

        // 🔹 Generate JWT
        String token = jwtUtil.generateToken(email);
        rabbitTemplate.convertAndSend(responseQueue, token);
    }

    @RabbitListener(queues = "auth.login")
    public void login(Map<String, String> request) {
        String email = request.get("email");
        String password = request.get("password");
        String responseQueue = request.get("responseQueue");

        // 🔹 Fetch user from customer service
        String userJson = (String) rabbitTemplate.convertSendAndReceive("customer.fetch", email);

        if (userJson == null || userJson.isEmpty()) {
            rabbitTemplate.convertAndSend(responseQueue, "❌ Invalid credentials!");
            return;
        }

        try {
            Map<String, String> user = objectMapper.readValue(userJson, Map.class);
            String storedPassword = user.get("password");

            // 🔹 Validate password
            if (!password.equals(storedPassword)) {
                rabbitTemplate.convertAndSend(responseQueue, "❌ Invalid credentials!");
                return;
            }

            // 🔹 Generate JWT
            String token = jwtUtil.generateToken(email);
            rabbitTemplate.convertAndSend(responseQueue, token);

        } catch (Exception e) {
            rabbitTemplate.convertAndSend(responseQueue, "❌ Error processing request");
        }
    }

    @RabbitListener(queues = "auth.validateToken")
    public void validateToken(Map<String, String> request) {
        String token = request.get("token");
        String responseQueue = request.get("responseQueue");

        boolean isValid = jwtUtil.validateToken(token);
        rabbitTemplate.convertAndSend(responseQueue, isValid ? "✅ Valid" : "❌ Invalid");
    }
}