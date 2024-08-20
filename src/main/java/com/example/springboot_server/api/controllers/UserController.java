package com.example.springboot_server.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot_server.api.models.User;
// import com.example.springboot_server.repositories.UserRepository;
// import com.example.springboot_server.service.UserService;
import com.example.springboot_server.repositories.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @PostMapping("/save")
    public User saveUsers(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.findAll();

    }

}
