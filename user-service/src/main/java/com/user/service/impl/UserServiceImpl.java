package com.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.entity.User;
import com.user.exception.UserNotFoundException;
import com.user.repository.UserRepository;
import com.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	   @Autowired
	    private UserRepository repository;

	    public User save(User user) {
	        return repository.save(user);
	    }

	    public List<User> findAll() {
	        return repository.findAll();
	    }
	    public User getById(Long id) {
	        return repository.findById(id)
	            .orElseThrow(() -> new UserNotFoundException("User not found"));
	    }

}
