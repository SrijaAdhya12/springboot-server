// import com.example.springapi.api.model.User;
// import com.example.springapi.service.UserService;


package com.example.java_server.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public ResponseEntity<String> Home() {
        return ResponseEntity.ok("Hello From Spring-boot Server");
    }
}