package com.leeseojune53.citylife.Controller;

import com.leeseojune53.citylife.Payload.Request.LoginRequest;
import com.leeseojune53.citylife.Payload.Response.TokenResponse;
import com.leeseojune53.citylife.Security.JwtTokenProvider;
import com.leeseojune53.citylife.Service.SessionService;
import io.jsonwebtoken.Jwt;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SessionController {
    private final SessionService sessionService;


    @GetMapping("/login")
    public TokenResponse login(
            @RequestBody  LoginRequest loginRequest
            ){
        String token = sessionService.CreateToken(loginRequest);
        JwtTokenProvider jwtTokenProvider = new JwtTokenProvider();
        System.out.println("t" + jwtTokenProvider.getuserId(token));
        return new TokenResponse("성공", token, token);
    }

}
