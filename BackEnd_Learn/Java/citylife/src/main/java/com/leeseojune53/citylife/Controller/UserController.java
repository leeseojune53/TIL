package com.leeseojune53.citylife.Controller;

import com.leeseojune53.citylife.Service.Signup.SignupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequiredArgsConstructor
public class UserController {
    private final SignupService signupService;


}
