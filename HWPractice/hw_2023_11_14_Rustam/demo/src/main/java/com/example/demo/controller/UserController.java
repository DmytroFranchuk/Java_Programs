package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    private List<User> userList;

    @Autowired
    private UserStorage userStorage;

    public UserController() {
        this.userList = new ArrayList<>();
        userList.add(new User("Dassin", "Joe", "jeday", "joe@exa.com"));
        userList.add(new User("Smith","Will", "wilkin", "will@exa.com"));
    }
    @GetMapping("/users/{email}")
    public User get(@PathVariable String email) {
        return userStorage.getUserByEmail(email);
    }

    @GetMapping("/users")
    public List<User> getAll() {
        return userList;
    }

    @PostMapping("/addUser")
    public User add(@RequestBody User user) {
        userStorage.addUser(user.getFirstName(),
                            user.getLastName(),
                            user.getNickName(),
                            user.getEmail());
        return userStorage.getUserByEmail(user.getEmail());
    }
}
