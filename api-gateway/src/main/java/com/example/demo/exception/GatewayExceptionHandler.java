package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebExceptionHandler;

import reactor.core.publisher.Mono;

public class GatewayExceptionHandler implements WebExceptionHandler{
	
	 @Override
	    public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {

	        ServerHttpResponse response = exchange.getResponse();
	        response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);

	        byte[] bytes = "Gateway error occurred"
	                .getBytes();

	        return response.writeWith(
	                Mono.just(response.bufferFactory().wrap(bytes)));
	    }
}
