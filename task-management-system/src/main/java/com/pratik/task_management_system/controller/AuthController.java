package com.pratik.task_management_system.controller;

import com.pratik.task_management_system.dto.AuthRequest;
import com.pratik.task_management_system.dto.AuthResponse;
import com.pratik.task_management_system.model.User;
import com.pratik.task_management_system.repository.UserRepository;
import com.pratik.task_management_system.security.JwtUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    public AuthController(UserRepository userRepository, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/signup")
    public String signup(@RequestBody AuthRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setRole("USER");           //default
        userRepository.save(user);
        return "User created";
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {

        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        String token = jwtUtil.generateToken(user.getUsername(),user.getRole());
        return new AuthResponse(token);
    }
}
