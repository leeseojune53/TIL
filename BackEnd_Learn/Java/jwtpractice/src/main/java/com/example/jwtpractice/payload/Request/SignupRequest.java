package com.example.jwtpractice.payload.Request;

import lombok.Getter;

@Getter
public class SignupRequest {
    private String userId;
    private String userPw;
}
