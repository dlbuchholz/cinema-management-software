package com.cinemamanagementsoftware.persistenceservice.consumers;

import com.cinemamanagementsoftware.persistenceservice.entities.CustomerEntity;
import com.cinemamanagementsoftware.persistenceservice.repositories.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.Map;

@Service
public class CustomerCommandConsumer {

    private final CustomerRepository customerRepository;
    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;
    private final PasswordEncoder passwordEncoder;

    public CustomerCommandConsumer(CustomerRepository customerRepository, RabbitTemplate rabbitTemplate, 
                                   ObjectMapper objectMapper, PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @RabbitListener(queues = "customer.fetch")
    public void fetchCustomer(String email) {
        Optional<CustomerEntity> customer = customerRepository.findByEmail(email);

        if (customer.isPresent()) {
            try {
                String userJson = objectMapper.writeValueAsString(customer.get());
                rabbitTemplate.convertAndSend("customer.fetch.response", userJson);
            } catch (Exception e) {
                rabbitTemplate.convertAndSend("customer.fetch.response", "");
            }
        } else {
            rabbitTemplate.convertAndSend("customer.fetch.response", "");
        }
    }

    @RabbitListener(queues = "customer.create")
    public void createCustomer(Map<String, String> request) {
        try {
            String email = request.get("email");
            String password = request.get("password");
            String telephone = request.get("telephone");
            String name = request.get("name");

            CustomerEntity newCustomer = new CustomerEntity(email, passwordEncoder.encode(password), name, telephone);
            customerRepository.save(newCustomer);
        } catch (Exception e) {
            System.err.println("❌ Error creating customer: " + e.getMessage());
        }
    }
}