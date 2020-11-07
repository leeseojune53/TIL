package com.example.jwt.Controller;

import com.example.jwt.Payload.Request.LoginRequest;
import com.example.jwt.Payload.Response.TokenResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @GetMapping("/auth")
    public TokenResponse auth(LoginRequest request){

    }
}
