package com.flowkart.userservice.controller;

import com.flowkart.userservice.dto.ApiResponse;
import com.flowkart.userservice.dto.RegisterRequest;
import com.flowkart.userservice.entity.User;
import com.flowkart.userservice.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> register(
            @Valid @RequestBody RegisterRequest request) {
        User user = userService.registerUser(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ApiResponse(true, "User registered successfully", user));
    }

    @GetMapping("/health")
    public ResponseEntity<ApiResponse> health() {
        return ResponseEntity.ok(
                new ApiResponse(true, "User Service is running", null));
    }
}