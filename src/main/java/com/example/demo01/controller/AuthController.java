package com.example.demo01.controller;


import com.example.demo01.dto.AuthRequest;
import com.example.demo01.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo01.security.JwtUtil;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

//    @GetMapping("/validate")
//    public ResponseEntity<String> validateToken(@RequestParam String token) {
//        try {
//            String username = jwtUtil.extractUsername(token);
//            boolean isValid = jwtUtil.validateToken(token, username);
//            return isValid ? ResponseEntity.ok("Token is valid for user: " + username)
//                    : ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Token");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Token: " + e.getMessage());
//        }
//    }
}
