package com.example.springboot_server.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.springboot_server.api.models.User;


@Service
public class UserService {

    private List<User> userList;

    public UserService() {
        userList = new ArrayList<>();

        User user1 = new User(1, "Srija", 20, "srija@mail.com");
        User user2 = new User(2, "pritam", 26, "pritam@mail.com");
        User user3 = new User(3, "Nahi", 40, "nasi@mail.com");
        User user4 = new User(4, "Umang", 32, "umang@mail.com");
        User user5 = new User(5, "Eva", 59, "eva@mail.com");

        userList.addAll(Arrays.asList(user1, user2, user3, user4, user5));
    }
   
    public Optional<User> getUser(Integer id) {
        Optional<User> optional = Optional.empty();
        for (User user : userList) {
            if (id == user.getId()) {
                optional = Optional.of(user);
                return optional;
            }
        }
        return optional;
    }
}
