package com.example.connectredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class ConnectredisApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConnectredisApplication.class, args);
    }

}
