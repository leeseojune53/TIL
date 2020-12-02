package com.example.chat.Payload.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserRequest {
    private String userId;
    private String userPw;

    public UsernamePasswordAuthenticationToken getAuthToken(int userCode){
        return new UsernamePasswordAuthenticationToken(userCode, userPw);
    }
}
