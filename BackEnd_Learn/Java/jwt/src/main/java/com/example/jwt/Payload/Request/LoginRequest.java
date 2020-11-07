package com.example.jwt.Payload.Request;

import lombok.Getter;

@Getter
public class LoginRequest {
    private String userId;
    private String userPw;
}
