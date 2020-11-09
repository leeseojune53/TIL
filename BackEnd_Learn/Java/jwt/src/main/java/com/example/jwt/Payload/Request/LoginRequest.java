package com.example.jwt.Payload.Request;

import lombok.Getter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Getter
public class LoginRequest {
    private String userId;
    private String userPw;

    public UsernamePasswordAuthenticationToken getAuthToken(int usercode){
        return new UsernamePasswordAuthenticationToken(usercode, userPw);
    }
}
