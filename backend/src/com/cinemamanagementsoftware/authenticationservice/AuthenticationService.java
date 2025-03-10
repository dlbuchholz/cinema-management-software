package com.cinemamanagementsoftware.authenticationservice;

import com.fasterxml.jackson.core.type.TypeReference;
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
    
    @RabbitListener(queues = "auth.ownerRegister")
    public String registerOwner(String jsonOwner) {
        try {
            // Deserialize request payload
            Map<String, String> request = objectMapper.readValue(jsonOwner, new TypeReference<Map<String, String>>() {});
            String email = request.get("email");
            String name = request.get("name");
            String password = request.get("password");

            // Synchronously fetch existing owner from cinema owner service
            String existingOwnerJson = (String) rabbitTemplate.convertSendAndReceive("owner.fetch", email);
            if (existingOwnerJson != null && !existingOwnerJson.trim().isEmpty() && !existingOwnerJson.equals("{}")) {
                return "{\"status\":\"error\", \"message\":\"Cinema owner already exists!\"}";
            }

            // Encode the password using PasswordEncoder
            String hashedPassword = passwordEncoder.encode(password);

            // Prepare new owner payload with the hashed password
            Map<String, String> newOwner = new HashMap<>();
            newOwner.put("email", email);
            newOwner.put("name", name);
            newOwner.put("password", hashedPassword);

            // Asynchronously send owner creation request
            rabbitTemplate.convertAndSend("owner.create", newOwner);

            // Generate JWT and return success JSON
            String token = jwtUtil.generateToken(email);
            return "{\"status\":\"success\", \"token\":\"" + token + "\"}";

        } catch (Exception e) {
            return "{\"status\":\"error\", \"message\":\"Error registering owner: " + e.getMessage() + "\"}";
        }
    }


    @RabbitListener(queues = "auth.login")
    public String login(Map<String, String> request) {
        String email = request.get("email");
        String password = request.get("password");

        try {
            // 🔹 Fetch user from Customer Service
            String customerJson = (String) rabbitTemplate.convertSendAndReceive("customer.fetch", email);
            if (customerJson != null && !customerJson.trim().isEmpty() && !customerJson.equals("{}")) {
                Map<String, String> customer = objectMapper.readValue(customerJson, Map.class);
                String storedPassword = customer.get("password");

                if (passwordEncoder.matches(password, storedPassword)) {
                    String token = jwtUtil.generateToken(email);
                    return String.format("{\"status\":\"success\", \"role\":\"customer\", \"token\":\"%s\", \"id\":%s, \"email\":\"%s\"}", 
                            token, customer.get("id"), customer.get("email"));
                }
            }

            // 🔹 Fetch user from Cinema Owner Service
            String ownerJson = (String) rabbitTemplate.convertSendAndReceive("owner.fetch", email);
            if (ownerJson != null && !ownerJson.trim().isEmpty() && !ownerJson.equals("{}")) {
                Map<String, String> owner = objectMapper.readValue(ownerJson, Map.class);
                String storedPassword = owner.get("password");

                if (passwordEncoder.matches(password, storedPassword)) {
                    String token = jwtUtil.generateToken(email);
                    return String.format("{\"status\":\"success\", \"role\":\"owner\", \"token\":\"%s\", \"id\":%s, \"email\":\"%s\"}", 
                            token, owner.get("id"), owner.get("email"));
                }
            }

            return "{\"status\":\"error\", \"message\":\"Invalid credentials!\"}";

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
    
    @RabbitListener(queues = "auth.logout")
    public String logout(Map<String, String> request) {
        String token = request.get("token");

        if (token == null || !JwtUtil.validateToken(token)) {
            return "{\"status\":\"error\", \"message\":\"Invalid token\"}";
        }

        JwtUtil.invalidateToken(token);
        return "{\"status\":\"success\", \"message\":\"Token has been revoked.\"}";
    }
}