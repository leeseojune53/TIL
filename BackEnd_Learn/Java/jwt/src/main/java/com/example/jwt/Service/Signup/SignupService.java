package com.example.jwt.Service.Signup;

import com.example.jwt.Payload.Request.SignupRequest;
import com.example.jwt.Payload.Response.LoginResponse;

public interface SignupService {
    LoginResponse signup(SignupRequest request);
}
