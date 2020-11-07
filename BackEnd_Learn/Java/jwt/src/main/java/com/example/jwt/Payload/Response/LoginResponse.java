package com.example.jwt.Payload.Response;

import com.example.jwt.Entity.User.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class LoginResponse {
    private boolean issuccess;
    private User user;
}
