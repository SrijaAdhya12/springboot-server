package com.example.springboot_server;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;


@Configuration
public class MongoConfig {

    @Value("${MONGODB_URI}")
    private String connectionString;

    @Bean
    public MongoClient mongoClient() {
        if (connectionString == null || connectionString.isEmpty()) {
            throw new IllegalArgumentException("MongoDB connection string is not defined");
        }
        return MongoClients.create(connectionString);
    }

    @Bean
    public MongoTemplate mongoTemplate(MongoClient mongoClient) {
        return new MongoTemplate(new SimpleMongoClientDatabaseFactory(mongoClient, "User"));
    }
}
