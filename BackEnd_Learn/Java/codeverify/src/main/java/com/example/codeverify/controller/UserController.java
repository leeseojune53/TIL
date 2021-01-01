package com.example.codeverify.controller;

import com.example.codeverify.Payload.AuthCode;
import com.example.codeverify.Payload.EmailRequest;
import com.example.codeverify.Payload.request.Signup;
import com.example.codeverify.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/verify")
    public String randomCode(EmailRequest request){
        userService.sendAuthCode(request);
        return "main";
    }

    @PostMapping("/verify/code")
    public String verify(AuthCode authCode){
        userService.authCode(authCode);
        return "main";
    }

    @PostMapping
    public String signup(Signup request){
        userService.signup(request);
        return "main";
    }
}
