package com.cinemamanagementsoftware.persistenceservice.consumers;

import com.cinemamanagementsoftware.persistenceservice.entities.CategoryEntity;
import com.cinemamanagementsoftware.persistenceservice.repositories.CategoryRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CategoryCommandConsumer {

    private final CategoryRepository categoryRepository;
    private final ObjectMapper objectMapper;

    public CategoryCommandConsumer(CategoryRepository categoryRepository, ObjectMapper objectMapper) {
        this.categoryRepository = categoryRepository;
        this.objectMapper = objectMapper;
    }

    @RabbitListener(queues = "category.fetch.all")
    public String fetchAllCategories() {
        try {
            List<CategoryEntity> categories = categoryRepository.findAll();
            return objectMapper.writeValueAsString(categories);
        } catch (Exception e) {
            return "{\"status\":\"error\",\"message\":\"Failed to fetch categories\"}";
        }
    }

    @RabbitListener(queues = "category.fetch")
    public String fetchCategory(String name) {
        try {
            Optional<CategoryEntity> category = categoryRepository.findByName(name);
            return category.map(c -> {
                try {
                    return objectMapper.writeValueAsString(c);
                } catch (Exception e) {
                    return "{\"status\":\"error\",\"message\":\"Failed to serialize category\"}";
                }
            }).orElse("{\"status\":\"error\",\"message\":\"Category not found\"}");
        } catch (Exception e) {
            return "{\"status\":\"error\",\"message\":\"Failed to fetch category\"}";
        }
    }

    @RabbitListener(queues = "category.create")
    public String createCategory(Map<String, String> categoryData) {
        try {
            if (!categoryData.containsKey("name")) {
                return "{\"status\":\"error\",\"message\":\"Missing required field: 'name'\"}";
            }

            String categoryName = categoryData.get("name");
            if (categoryRepository.findByName(categoryName).isPresent()) {
                return "{\"status\":\"error\",\"message\":\"Category already exists\"}";
            }

            CategoryEntity category = new CategoryEntity(categoryName);
            categoryRepository.save(category);

            return objectMapper.writeValueAsString(category);
        } catch (Exception e) {
            return "{\"status\":\"error\",\"message\":\"Failed to create category: " + e.getMessage() + "\"}";
        }
    }

    @RabbitListener(queues = "category.delete")
    public String deleteCategory(String name) {
        try {
            Optional<CategoryEntity> category = categoryRepository.findByName(name);
            if (category.isEmpty()) {
                return "{\"status\":\"error\",\"message\":\"Category not found\"}";
            }

            categoryRepository.delete(category.get());
            return "{\"status\":\"success\",\"message\":\"Category deleted\"}";
        } catch (Exception e) {
            return "{\"status\":\"error\",\"message\":\"Failed to delete category\"}";
        }
    }
}