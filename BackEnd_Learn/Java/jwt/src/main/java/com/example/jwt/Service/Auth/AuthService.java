package com.example.jwt.Service.Auth;

import com.example.jwt.Payload.Request.LoginRequest;
import com.example.jwt.Payload.Response.TokenResponse;

public interface AuthService {
    TokenResponse signIn(LoginRequest request);
}
