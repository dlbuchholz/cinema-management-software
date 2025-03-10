package com.cinemamanagementsoftware.persistenceservice.consumers;

import java.util.Map;
import java.util.Optional;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.cinemamanagementsoftware.persistenceservice.entities.CinemaOwnerEntity;
import com.cinemamanagementsoftware.persistenceservice.entities.CustomerEntity;
import com.cinemamanagementsoftware.persistenceservice.repositories.CinemaOwnerRepository;
import com.cinemamanagementsoftware.persistenceservice.repositories.CustomerRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class UserCommandConsumer {
	
    private final CustomerRepository customerRepository;
    private final CinemaOwnerRepository cinemaOwnerRepository;
    private final ObjectMapper objectMapper;
    
    
    public UserCommandConsumer(CustomerRepository customerRepository, CinemaOwnerRepository cinemaOwnerRepository, ObjectMapper objectMapper) {
        this.customerRepository = customerRepository;
        this.objectMapper = objectMapper;
        this.cinemaOwnerRepository = cinemaOwnerRepository;
    }
	
	@RabbitListener(queues = "auth.login")
	public String processUserLogin(String jsonRequest) {
	    try {
	        // Deserialize request payload
	        Map<String, String> requestMap = objectMapper.readValue(jsonRequest, new TypeReference<Map<String, String>>() {});
	        String email = requestMap.get("email");
	        String password = requestMap.get("password");

	        // Check if user is a customer
	        Optional<CustomerEntity> customerOpt = customerRepository.findByEmail(email);
	        if (customerOpt.isPresent()) {
	            CustomerEntity customer = customerOpt.get();
	            if (!customer.getPassword().equals(password)) {
	                return "{\"status\":\"error\",\"message\":\"Invalid credentials.\"}";
	            }
	            return String.format("{\"status\":\"success\",\"role\":\"customer\", \"id\":%d, \"email\":\"%s\"}", 
	                    customer.getId(), customer.getEmail());
	        }

	        // Check if user is a cinema owner
	        Optional<CinemaOwnerEntity> ownerOpt = cinemaOwnerRepository.findByEmail(email);
	        if (ownerOpt.isPresent()) {
	            CinemaOwnerEntity owner = ownerOpt.get();
	            if (!owner.getPassword().equals(password)) {
	                return "{\"status\":\"error\",\"message\":\"Invalid credentials.\"}";
	            }
	            return String.format("{\"status\":\"success\",\"role\":\"owner\", \"id\":%d, \"email\":\"%s\"}", 
	                    owner.getId(), owner.getEmail());
	        }

	        // No matching user found
	        return "{\"status\":\"error\",\"message\":\"User not found.\"}";

	    } catch (Exception e) {
	        return "{\"status\":\"error\",\"message\":\"Error processing login: " + e.getMessage() + "\"}";
	    }
	}

}
