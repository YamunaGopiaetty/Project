package com.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.entity.Order;
import com.order.repository.OrderRepository;
import com.order.service.OrderService;


@RestController
@RequestMapping("/orders")
public class OrderController {
	
	  @Autowired
	    private OrderService service;

	 @PostMapping
	    public Order createOrder(@RequestBody Order order) {
	        return service.placeOrder(order);
	    }}
