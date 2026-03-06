package com.example.demo.controller;

import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        try {
            User user = userService.register(request);
            AuthResponse response = new AuthResponse(
                "Registration successful!",
                true,
                user.getName(),
                user.getEmail(),
                user.getRole().name()
            );
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            AuthResponse response = new AuthResponse(e.getMessage(), false, null, null, null);
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        try {
            User user = userService.login(request);
            AuthResponse response = new AuthResponse(
                "Login successful!",
                true,
                user.getName(),
                user.getEmail(),
                user.getRole().name()
            );
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            AuthResponse response = new AuthResponse(e.getMessage(), false, null, null, null);
            return ResponseEntity.badRequest().body(response);
        }
    }
}
