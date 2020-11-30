package com.example.jwt.Controller;

import com.example.jwt.Entity.User.User;
import com.example.jwt.Payload.Request.SignupRequest;
import com.example.jwt.Payload.Response.LoginResponse;
import com.example.jwt.Service.Signup.SignupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class SignupController {
    private final SignupService signupService;

    @PostMapping("/user")
    public LoginResponse signup(@RequestBody @Valid SignupRequest request){
        return signupService.signup(request);
    }
}
