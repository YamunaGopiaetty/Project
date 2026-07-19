package com.auth_service.service;

import org.springframework.stereotype.Service;

import com.auth_service.util.JwtUtil;

@Service
public class AuthService {
	
	private final JwtUtil jwtUtil;

    public AuthService(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    public String login(String username, String password) {

        
        if ("yamuna".equals(username) && "password".equals(password)) {

            Long userId = 101L;
            return jwtUtil.generateToken(username, userId);
        }

        throw new RuntimeException("Invalid username or password");
    }

}
