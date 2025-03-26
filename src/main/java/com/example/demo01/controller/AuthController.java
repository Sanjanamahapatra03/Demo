package com.example.demo01.controller;


import com.example.demo01.dto.AuthRequest;
import com.example.demo01.security.JwtUtil;
import com.example.demo01.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @GetMapping("/validate")
    public ResponseEntity<String> validateToken(@RequestParam String token) {
        try {
            String username = jwtUtil.extractUsername(token);
            boolean isValid = jwtUtil.validateToken(token, username);

            if (isValid) {
                return ResponseEntity.ok("Token is valid for user: " + username);
            } else {
                return ResponseEntity.status(401).body("Invalid or expired token");
            }
        } catch (Exception e) {
            return ResponseEntity.status(401).body("Invalid token: " + e.getMessage());
        }
    }
}
