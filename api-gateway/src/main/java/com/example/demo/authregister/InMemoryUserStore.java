package com.example.demo.authregister;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

@Component
public class InMemoryUserStore {
	
	private final Map<String, String> users = new ConcurrentHashMap<>();

    public void register(String username, String password) {
        users.put(username, password);
    }

    public boolean validate(String username, String password) {
        return password.equals(users.get(username));
    }

}
