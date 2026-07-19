package com.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.order.dto.UserResponse;

@FeignClient(name = "USER-SERVICE", url = "http://localhost:8081")
public interface UserClient {
	
	@GetMapping("/users/{id}")
	
    UserResponse getUserById(@PathVariable Long id);

}
