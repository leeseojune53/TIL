package com.example.chat.Payload.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class TokenResponse {
    private final String AccessToken;
    private final String RefreshToken;
}
