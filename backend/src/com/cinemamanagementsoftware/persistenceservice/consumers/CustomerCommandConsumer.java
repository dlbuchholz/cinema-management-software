package com.cinemamanagementsoftware.persistenceservice.consumers;

import com.cinemamanagementsoftware.persistenceservice.entities.CustomerEntity;
import com.cinemamanagementsoftware.persistenceservice.repositories.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.Map;

@Service
public class CustomerCommandConsumer {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @RabbitListener(queues = "customer.fetchById")
    public String fetchCustomerById(String customerId) {
        try {
            Long id = Long.valueOf(customerId);
            Optional<CustomerEntity> customerOpt = customerRepository.findById(id);

            if (customerOpt.isEmpty()) {
                return "{\"status\":\"error\",\"message\":\"Customer not found.\"}";
            }

            return objectMapper.writeValueAsString(customerOpt.get());
        } catch (Exception e) {
            return "{\"status\":\"error\",\"message\":\"Error retrieving customer: " + e.getMessage() + "\"}";
        }
    }

    @RabbitListener(queues = "customer.fetch")
    public String fetchCustomerByEmail(String email) {
        try {
            Optional<CustomerEntity> customerOpt = customerRepository.findByEmail(email);

            if (customerOpt.isEmpty()) {
                return "{\"status\":\"error\",\"message\":\"Customer not found.\"}";
            }

            return objectMapper.writeValueAsString(customerOpt.get());
        } catch (Exception e) {
            return "{\"status\":\"error\",\"message\":\"Error retrieving customer: " + e.getMessage() + "\"}";
        }
    }

    @RabbitListener(queues = "customer.create")
    public String createCustomer(String jsonCustomer) {
        try {
            // Deserialize request payload
            CustomerEntity customer = objectMapper.readValue(jsonCustomer, CustomerEntity.class);

            // Check if email already exists
            Optional<CustomerEntity> existingCustomer = customerRepository.findByEmail(customer.getEmail());
            if (existingCustomer.isPresent()) {
                return "{\"status\":\"error\",\"message\":\"User already exists!\"}";
            }

            // Save customer to database
            customerRepository.save(customer);
            return "{\"status\":\"success\",\"message\":\"Customer registered successfully!\"}";

        } catch (Exception e) {
            return "{\"status\":\"error\",\"message\":\"Error creating customer: " + e.getMessage() + "\"}";
        }
    }
}
