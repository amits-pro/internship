package com.bv.gms.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bv.gms.dto.LoginDto;
import com.bv.gms.entities.User;
import com.bv.gms.service.UserService;

import jakarta.validation.Valid;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:5000")  // Allow only requests from localhost:3000 (React/Angular front-end)
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@Valid @RequestBody User user) {
        return ResponseEntity.ok(userService.registerUser(user));
    }
    
    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("hello");
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@Valid @RequestBody LoginDto loginDto) throws Exception {
        System.out.println("user controller");
        
        try {
        	String token = userService.authenticateAndGenerateToken(loginDto);
            if (token == null) {
            	System.out.println("null token");
                return ResponseEntity.status(401).body("Invalid credentials");
            }
            return ResponseEntity.ok(token);
        }
        catch(Exception ex) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    	
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getUserProfile(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findUserById(id));
    }
}
