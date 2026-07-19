package com.example.demo.filter;

import org.springframework.http.HttpHeaders; 

import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;

import com.example.demo.util.JwtUtil;

import reactor.core.publisher.Mono;

@Component
public class JwtAuthFilter implements WebFilter{
	

    private final JwtUtil jwtUtil;

    public JwtAuthFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {

    	/* String authHeader = exchange.getRequest()
                .getHeaders()
                .getFirst(HttpHeaders.AUTHORIZATION);

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            // No token → SecurityConfig handles response
            return chain.filter(exchange);
        }

        String token = authHeader.substring(7);

        if (!jwtUtil.validateToken(token)) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            byte[] bytes = "Invalid or expired token. Please sign in again"
                    .getBytes();

            return exchange.getResponse().writeWith(
                    Mono.just(exchange.getResponse()
                            .bufferFactory()
                            .wrap(bytes)));
        }

        return chain.filter(exchange);
    }*/
    	
    	/*String path = exchange.getRequest().getPath().toString();
        if (path.startsWith("/auth")) {
            return chain.filter(exchange);
        }
    	
    String authHeader = exchange.getRequest()
            .getHeaders()
            .getFirst(HttpHeaders.AUTHORIZATION);

    if (authHeader != null && authHeader.startsWith("Bearer ")) {

        String token = authHeader.substring(7);

        if (jwtUtil.validateToken(token)) {

            String username = jwtUtil.extractUsername(token);
            Long userId = jwtUtil.extractUserId(token);

            // ✅ Forward user details to services
            return chain.filter(
                    exchange.mutate()
                            .request(exchange.getRequest().mutate()
                                    .header("X-USERNAME", username)
                                    .header("X-USER-ID", String.valueOf(userId))
                                    .build())
                            .build()
            );
        }
    }

    //return chain.filter(exchange);
    exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
    return exchange.getResponse().setComplete();
}*/
    	
    	ServerHttpRequest request = exchange.getRequest();

        if (!request.getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
            return chain.filter(exchange);
        }

        String authHeader = request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
        String token = authHeader.replace("Bearer ", "");

        jwtUtil.validateToken(token); // existing logic

        return chain.filter(exchange);

    }
    
}
