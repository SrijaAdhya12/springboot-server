package com.example.springboot_server.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot_server.api.models.User;
import com.example.springboot_server.service.UserService;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        Optional<List<User>> users = userService.find();
        if (users.isPresent())
            return ResponseEntity.ok(users.get());
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id) {
        Optional<User> user = userService.findById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User newuser = userService.createUser(user);
        return new ResponseEntity<>(newuser, HttpStatus.CREATED);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User user) {
        Optional<User> updatedUser = userService.updateById(id, user);
        if (updatedUser.isPresent()) {
            return ResponseEntity.ok(updatedUser.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/users/{id}")
    public ResponseEntity<User> editUser(@PathVariable int id, @RequestBody User user) {
        Optional<User> editeedUser = userService.editUser(id, user);
        if (editeedUser.isPresent()) {
            return ResponseEntity.ok(editeedUser.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Integer id) {
        Optional<User> deletedUser = userService.deleteUser(id);
        if (deletedUser.isPresent()) {
            return ResponseEntity.ok(deletedUser.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/users")
    public ResponseEntity<String> deleteAllUsers() {
        userService.deleteAllUsers();
        return ResponseEntity.ok("All users deleted");
    }
}
