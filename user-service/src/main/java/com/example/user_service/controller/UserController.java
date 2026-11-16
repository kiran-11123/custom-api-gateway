package com.example.user_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/users")
public class UserController {

      @GetMapping("/{id}")
    public String getUser(@PathVariable  Long id) {
        // Logic to retrieve user information based on userId
        return "User information for userId: " + id;
    }
      @GetMapping("/health")
    public String health() {

        return "User Service is UP";
    }

}
