package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserStorage {
    private final Map<String, User> users;

    public UserStorage() {
        this.users = new HashMap<>();
        users.put("john@example.com", new User("john","doe", "fanuk","john@example.com"));
        users.put("janet@example.com", new User("janet", "smith", "nitro","janet@example.com"));
    }

    public User getUserByEmail(String email) {
        return users.get(email);
    }

    public void addUser(String name, String lastName, String nickname, String email) {
        User newUser = new User(name, lastName, nickname, email);
        users.put(email, newUser);
    }
}
