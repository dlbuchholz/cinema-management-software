package com.cinemamanagementsoftware.applicationservice.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;

    public CategoryController(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper) {
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
    }

    @GetMapping
    public String fetchCategories() {
        try {
            String response = (String) rabbitTemplate.convertSendAndReceive("category.fetch.all", "");
            return response != null ? response : "{\"status\":\"error\",\"message\":\"Category fetch timeout\"}";
        } catch (Exception e) {
            return "{\"status\":\"error\",\"message\":\"Failed to fetch categories: " + e.getMessage() + "\"}";
        }
    }

    @GetMapping("/{name}")
    public String fetchCategory(@PathVariable String name) {
        try {
            String response = (String) rabbitTemplate.convertSendAndReceive("category.fetch", name);
            return response != null ? response : "{\"status\":\"error\",\"message\":\"Category fetch timeout\"}";
        } catch (Exception e) {
            return "{\"status\":\"error\",\"message\":\"Failed to fetch category: " + e.getMessage() + "\"}";
        }
    }

    @PostMapping
    public String createCategory(@RequestBody Map<String, String> categoryData) {
        try {
            String response = (String) rabbitTemplate.convertSendAndReceive("category.create", categoryData);
            return response != null ? response : "{\"status\":\"error\",\"message\":\"Category creation timeout\"}";
        } catch (Exception e) {
            return "{\"status\":\"error\",\"message\":\"Failed to create category: " + e.getMessage() + "\"}";
        }
    }

    @DeleteMapping("/{name}")
    public String deleteCategory(@PathVariable String name) {
        try {
            String response = (String) rabbitTemplate.convertSendAndReceive("category.delete", name);
            return response != null ? response : "{\"status\":\"error\",\"message\":\"Category deletion timeout\"}";
        } catch (Exception e) {
            return "{\"status\":\"error\",\"message\":\"Failed to delete category: " + e.getMessage() + "\"}";
        }
    }
}