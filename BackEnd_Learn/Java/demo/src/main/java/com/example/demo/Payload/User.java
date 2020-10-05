package com.example.demo.Payload;

import lombok.Data;

@Data
public class User {
    private String id;
    private String password;

    public User(String id, String password) {
        this.id = id;
        this.password = password;
    }
}
