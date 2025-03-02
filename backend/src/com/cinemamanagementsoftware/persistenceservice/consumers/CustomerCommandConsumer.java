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

    public CustomerCommandConsumer(CustomerRepository customerRepository, RabbitTemplate rabbitTemplate, 
                                   ObjectMapper objectMapper) {
        this.customerRepository = customerRepository;
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
    }

    @RabbitListener(queues = "customer.fetch")
    public String fetchCustomer(String email) {
        Optional<CustomerEntity> customer = customerRepository.findByEmail(email);

        if (customer.isPresent()) {
            try {
                return objectMapper.writeValueAsString(customer.get());
            } catch (Exception e) {
                return "{}";
            }
        } else {
            return "{}";
        }
    }

    @RabbitListener(queues = "customer.create")
    public void createCustomer(Map<String, String> request) {
        try {
            String email = request.get("email");
            String password = request.get("password");
            String telephone = request.get("telephone");
            String name = request.get("name");

            CustomerEntity newCustomer = new CustomerEntity(email, password, name, telephone);
            customerRepository.save(newCustomer);
        } catch (Exception e) {
            System.err.println("Error creating customer: " + e.getMessage());
        }
    }
}