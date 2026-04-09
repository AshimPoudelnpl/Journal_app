package com.example.journalapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.example.journalapp.repository")
public class JournalappApplication {

    public static void main(String[] args) {
        SpringApplication.run(JournalappApplication.class, args);
    }
}
