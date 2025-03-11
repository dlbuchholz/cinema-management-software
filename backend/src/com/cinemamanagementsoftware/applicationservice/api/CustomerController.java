package com.cinemamanagementsoftware.applicationservice.api;

import com.cinemamanagementsoftware.applicationservice.handler.UserHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final UserHandler userHandler;

    @Autowired
    public CustomerController(UserHandler userHandler) {
        this.userHandler = userHandler;
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getCustomer(@PathVariable Long id) {
        return userHandler.getUserById(id, "customer.fetchById");
    }

    @GetMapping("/me")
    public ResponseEntity<String> getCustomerProfile() {
        return userHandler.getUserProfile("customer.fetch");
    }
    
    @GetMapping("/id/{email}")
    public ResponseEntity<String> getCustomerId(@PathVariable("email") String email) {
            String response = userHandler.fetchCustomerId(email);
            return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody String jsonCustomer) {
        return userHandler.register(jsonCustomer, 
                "http://www.example.org/cinemaManagementSoftware#//Customer",
                "auth.register");
    }
}
