package com.example.jwt.Controller;

import com.example.jwt.Payload.Request.LoginRequest;
import com.example.jwt.Payload.Response.TokenResponse;
import com.example.jwt.Service.Auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping
    public TokenResponse auth(@RequestBody LoginRequest request){
        return authService.signIn(request);
    }

    @PutMapping
    public TokenResponse update(@RequestHeader("refresh_token") String request){
        return authService.refreshToken(request);
    }

}
