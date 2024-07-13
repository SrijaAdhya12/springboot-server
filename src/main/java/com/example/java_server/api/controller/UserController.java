// package com.example.java_server.api.controller;

// import java.util.List;
// import java.util.Optional;

// // import org.springframework.beans.factory.annotation.Autowired;
// // import org.springframework.web.bind.annotation.GetMapping;
// // import org.springframework.web.bind.annotation.RequestParam;
// // import org.springframework.web.bind.annotation.RestController;
// // import org.springframework.http.ResponseEntity;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.java_server.api.model.User;
// import com.example.java_server.service.UserService;



package com.example.java_server.api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.java_server.api.model.User;
import com.example.java_server.service.UserService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable Integer id) {
        Optional<User> user = userService.findById(id);
        if (user.isPresent())
            return ResponseEntity.ok(user.get());

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        Optional<List<User>> users = userService.find();
        if (users.isPresent())
            return ResponseEntity.ok(users.get());
        return ResponseEntity.notFound().build();
    }
}