package com.auth_service.util;
import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

	    private static final String SECRET =
	            "mysecretkeymysecretkeymysecretkey123";

	    private Key getSigningKey() {
	        return Keys.hmacShaKeyFor(SECRET.getBytes());
	    }

	    public String generateToken(String username, Long userId) {
 
	        return Jwts.builder()
	                .setSubject(username)          
	                .claim("userId", userId)       
	                .setIssuedAt(new Date())
	                .setExpiration(
	                        new Date(System.currentTimeMillis() + 60 * 60 * 1000)
	                )
	                .signWith(getSigningKey())
	                .compact();
	    }

}
