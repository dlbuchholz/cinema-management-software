package com.cinemamanagementsoftware.applicationservice.api;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinemamanagementsoftware.applicationservice.handler.UserHandler;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserHandler userHandler;

    @Autowired
    public UserController(UserHandler userHandler) {
        this.userHandler = userHandler;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> user) {
        return userHandler.login(user);
    }
    
    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestBody Map<String, String> request) {
        try {
            if (!request.containsKey("token")) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("{\"status\":\"error\", \"message\":\"Token is required\"}");
            }

            String response = userHandler.processLogout(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"status\":\"error\", \"message\":\"Error processing logout\"}");
        }
    }
    
    @PostMapping("/validate-token")
    public ResponseEntity<String> validateToken(@RequestBody Map<String, String> request) {
        try {
            if (!request.containsKey("token") || request.get("token").trim().isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("{\"status\":\"error\", \"message\":\"Token is required\"}");
            }

            String response = userHandler.processTokenValidation(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"status\":\"error\", \"message\":\"Error validating token\"}");
        }
    }
    
}

