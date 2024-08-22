package com.example.springboot_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
// @PropertySource("classpath:.env")
@EnableMongoRepositories
public class SpringbootServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootServerApplication.class, args);
    }

}
