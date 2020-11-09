package com.example.jwt.Payload.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TokenResponse {
    private String accessToken;
    private String refreshToken;
    private String tokenExpired;
}
