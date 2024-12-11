package com.klef.jfsd.controller;

import com.klef.jfsd.model.User;
import com.klef.jfsd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000") 
public class UserController {

    @Autowired
    private UserService userService;

    // Signup Endpoint
    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody User user) {
        try {
            userService.registerUser(user);
            return ResponseEntity.ok("User registered successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Signin Endpoint
    @PostMapping("/signin")
    public ResponseEntity<String> signin(@RequestBody User user) {
        boolean authenticated = userService.authenticateUser(user.getEmail(), user.getPassword(), user.getUserType());
        if (authenticated) {
            return ResponseEntity.ok("Signin successful");
        } else {
            return ResponseEntity.badRequest().body("Invalid credentials or role");
        }
    }
}
