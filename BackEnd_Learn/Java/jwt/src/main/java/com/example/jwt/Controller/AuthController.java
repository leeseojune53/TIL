package com.example.jwt.Controller;

import com.example.jwt.Payload.Request.LoginRequest;
import com.example.jwt.Payload.Response.TokenResponse;
import com.example.jwt.Service.Auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/auth")
    public TokenResponse auth(@RequestBody LoginRequest request){
        return authService.signIn(request);
    }

}
