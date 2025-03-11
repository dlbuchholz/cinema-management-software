package com.cinemamanagementsoftware.applicationservice.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinemamanagementsoftware.applicationservice.handler.UserHandler;

@RestController
@RequestMapping("/api/owners")
public class CinemaOwnerController {

    private final UserHandler userHandler;

    @Autowired
    public CinemaOwnerController(UserHandler userHandler) {
        this.userHandler = userHandler;
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getOwner(@PathVariable Long id) {
        return userHandler.getUserById(id, "owner.fetchById");
    }

    @GetMapping("/me")
    public ResponseEntity<String> getOwnerProfile() {
        return userHandler.getUserProfile("owner.fetch");
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody String jsonOwner) {
        return userHandler.register(jsonOwner, 
                "http://www.example.org/cinemaManagementSoftware#//CinemaOwner",
                "auth.ownerRegister");
    }
}

