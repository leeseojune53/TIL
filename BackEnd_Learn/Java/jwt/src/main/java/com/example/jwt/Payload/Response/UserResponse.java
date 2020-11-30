package com.example.jwt.Payload.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserResponse {
    private String userId;
    private String userPw;
}
