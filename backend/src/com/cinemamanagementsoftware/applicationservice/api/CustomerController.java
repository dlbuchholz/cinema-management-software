package com.cinemamanagementsoftware.applicationservice.api;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final RabbitTemplate rabbitTemplate;

    public CustomerController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
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
