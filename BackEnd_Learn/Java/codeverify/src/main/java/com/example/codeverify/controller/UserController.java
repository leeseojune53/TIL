package com.example.codeverify.controller;

import com.example.codeverify.Payload.AuthCode;
import com.example.codeverify.Payload.EmailRequest;
import com.example.codeverify.Payload.request.Signup;
import com.example.codeverify.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/verify")
    public void randomCode(EmailRequest request){
        userService.sendAuthCode(request);
    }

    @PostMapping("/verify/code")
    public void verify(AuthCode authCode){
        userService.authCode(authCode);
    }

    @PostMapping
    public void signup(Signup request){
        userService.signup(request);
    }
}
