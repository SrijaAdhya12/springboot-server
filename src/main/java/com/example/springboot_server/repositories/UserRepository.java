package com.example.springboot_server.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.springboot_server.api.models.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}