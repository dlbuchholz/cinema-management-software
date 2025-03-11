package com.cinemamanagementsoftware.applicationservice.handler;

import java.util.Map;

import org.eclipse.emfcloud.jackson.module.EMFModule;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.cinemamanagementsoftware.applicationservice.api.APIUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class UserHandler {

    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;

    @Autowired
    public UserHandler(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper) {
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
        this.objectMapper.registerModule(new EMFModule());
    }

    public ResponseEntity<String> getUserById(Long id, String queueName) {
        try {
            // Fetch user via RabbitMQ
            Object response = rabbitTemplate.convertSendAndReceive(queueName, id);
            if (response == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("{\"status\":\"error\",\"message\":\"User not found\"}");
            }
            return ResponseEntity.ok(response.toString());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"status\":\"error\",\"message\":\"Error retrieving user: " + e.getMessage() + "\"}");
        }
    }

    public ResponseEntity<String> getUserProfile(String queueName) {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication == null || !authentication.isAuthenticated()) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body("{\"status\":\"error\",\"message\":\"Unauthorized\"}");
            }

            String email = (String) authentication.getPrincipal();
            Object response = rabbitTemplate.convertSendAndReceive(queueName, email);

            if (response == null || response.toString().trim().isEmpty() || response.toString().equals("{}")) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("{\"status\":\"error\",\"message\":\"User not found\"}");
            }

            return ResponseEntity.ok(response.toString());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"status\":\"error\",\"message\":\"Error retrieving user profile: " + e.getMessage() + "\"}");
        }
    }
    
    public String fetchCustomerId(String email) {
        try {
            Object response = rabbitTemplate.convertSendAndReceive("customer.getId", email);
            
            if (response == null || response.toString().trim().isEmpty()) {
                return "{\"status\":\"error\",\"message\":\"Customer not found\"}";
            }

            return response.toString();
        } catch (Exception e) {
            return "{\"status\":\"error\",\"message\":\"Error processing request: " + e.getMessage() + "\"}";
        }
    }

    public ResponseEntity<String> login(Map<String, String> user) {
        try {
            if (!user.containsKey("email") || !user.containsKey("password")) {
                return ResponseEntity.badRequest()
                        .body("{\"status\":\"error\",\"message\":\"Missing required fields: email and password\"}");
            }

            // Send login request to RabbitMQ (single queue for all users)
            Object response = rabbitTemplate.convertSendAndReceive("auth.login", user);
            if (response == null) {
                return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT)
                        .body("{\"status\":\"error\",\"message\":\"Timeout\"}");
            }

            // Deserialize response and check role
            Map<String, Object> responseMap = objectMapper.readValue(response.toString(), new TypeReference<Map<String, Object>>() {});
            if (responseMap.containsKey("status") && "error".equals(responseMap.get("status"))) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(objectMapper.writeValueAsString(responseMap));
            }

            if (!responseMap.containsKey("role")) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("{\"status\":\"error\",\"message\":\"Invalid authentication response.\"}");
            }

            return ResponseEntity.ok(response.toString());

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"status\":\"error\",\"message\":\"Error processing login: " + e.getMessage() + "\"}");
        }
    }

    public ResponseEntity<String> register(String jsonUser, String eClassUri, String queueName) {
        try {
            // Ensure correct EClass
            String validatedJson = APIUtils.ensureEClassField(jsonUser, eClassUri);

            // Validate required fields
            Map<String, String> userMap = objectMapper.readValue(validatedJson, new TypeReference<Map<String, String>>() {});
            if (!userMap.containsKey("name") || !userMap.containsKey("email") || !userMap.containsKey("password")) {
                return ResponseEntity.badRequest()
                        .body("{\"status\":\"error\",\"message\":\"Missing required fields!\"}");
            }

            // Send request to RabbitMQ
            String response = (String) rabbitTemplate.convertSendAndReceive(queueName, userMap);
            if (response != null) {
                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT)
                        .body("{\"status\":\"error\",\"message\":\"Registration Timeout\"}");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"status\":\"error\",\"message\":\"Error processing registration: " + e.getMessage() + "\"}");
        }
    }
    
    public String processLogout(Map<String, String> request) {
        try {
            return (String) rabbitTemplate.convertSendAndReceive("auth.logout", request);
        } catch (Exception e) {
            return "{\"status\":\"error\", \"message\":\"Logout request failed\"}";
        }
    }
    
    public String processTokenValidation(Map<String, String> request) {
        try {
            return (String) rabbitTemplate.convertSendAndReceive("auth.validateToken", request);
        } catch (Exception e) {
            return "{\"status\":\"error\", \"message\":\"Token validation request failed\"}";
        }
    }
}

