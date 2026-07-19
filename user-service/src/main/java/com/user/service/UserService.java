package com.user.service;

import java.util.List;

import com.user.entity.User;

public interface UserService {
	
	User save(User user);
	List<User> findAll();
	User getById(Long id);

}
