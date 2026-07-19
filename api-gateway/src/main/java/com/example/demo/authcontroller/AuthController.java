package com.example.demo.authcontroller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.authregister.InMemoryUserStore;
import com.example.demo.util.JwtUtil;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
	
	 private final InMemoryUserStore userStore ;
     private final JwtUtil jwtUtil;

    public AuthController(InMemoryUserStore userStore, JwtUtil jwtUtil) {
		super();
		this.userStore = userStore;
		this.jwtUtil = jwtUtil;
	}

	// Candidate registers
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Map<String, String> request) {
        userStore.register(request.get("username"), request.get("password"));
        return ResponseEntity.ok("User registered successfully");
    }

    // Candidate logs in → token auto generated
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Map<String, String> request) {

        boolean valid = userStore.validate(
                request.get("username"),
                request.get("password")
        );

        if (!valid) {
            return ResponseEntity.status(401).build();
        }

        // 🔑 JWT GENERATED AUTOMATICALLY
        String token = JwtUtil.generateToken(request.get("username"));

        return ResponseEntity.ok(Map.of(
                "accessToken", token
        ));
    }

}
