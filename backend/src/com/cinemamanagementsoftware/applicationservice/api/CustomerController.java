package com.cinemamanagementsoftware.applicationservice.api;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.UUID;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final RabbitTemplate rabbitTemplate;

    public CustomerController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping("/register")
    public String register(@RequestBody HashMap<String, String> user) {
        String responseQueue = "auth.response." + UUID.randomUUID();
        user.put("responseQueue", responseQueue);

        rabbitTemplate.convertAndSend("auth.register", user);
        
        // ✅ Wait for response
        Object response = rabbitTemplate.receiveAndConvert(responseQueue, 5000);
        
        return response != null ? response.toString() : "{\"error\": \"Timeout\"}";
    }

    @PostMapping("/login")
    public String login(@RequestBody HashMap<String, String> user) {
        String responseQueue = "auth.response." + UUID.randomUUID();
        user.put("responseQueue", responseQueue);

        rabbitTemplate.convertAndSend("auth.login", user);
        return (String) rabbitTemplate.receiveAndConvert(responseQueue, 5000);
    }

    @PostMapping("/validate")
    public String validateToken(@RequestBody HashMap<String, String> request) {
        String responseQueue = "auth.response." + UUID.randomUUID();
        request.put("responseQueue", responseQueue);

        rabbitTemplate.convertAndSend("auth.validateToken", request);
        return (String) rabbitTemplate.receiveAndConvert(responseQueue, 5000);
    }
}