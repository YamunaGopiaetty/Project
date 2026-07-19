package com.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.client.UserClient;
import com.order.dto.UserResponse;
import com.order.entity.Order;
import com.order.exception.OrderException;
import com.order.repository.OrderRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class OrderService {
	
	 @Autowired
	  private OrderRepository repo;
	 
	  @Autowired
	    private UserClient userClient;
	  
	  

	  @CircuitBreaker(name = "userServiceCB", fallbackMethod = "fallbackPlaceOrder")
	  public Order placeOrder(Order order) {

	        // Calling User Service using Feign
	        UserResponse user = userClient.getUserById(order.getUserId());

	        if (user == null) {
	            throw new OrderException("User not found for order");
	        }

	        return repo.save(order);
	    }
	  
	  public String fallbackPlaceOrder(Order order, Exception ex) {
	        return "User service is currently unavailable. Order will be processed later.";
	    }

	  

}
