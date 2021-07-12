package io.github.leeseojune53.auth.controller;

import io.github.leeseojune53.auth.dto.UserAuthRequest;
import io.github.leeseojune53.auth.dto.UserRegisterRequest;
import io.github.leeseojune53.auth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody UserRegisterRequest registerRequest) {
        userService.userRegister(registerRequest);
    }

    @PostMapping("/auth")
    public String token(@RequestBody UserAuthRequest authRequest) {
        return userService.getAccessToken(authRequest);
    }

    @GetMapping("/user/info")
    public String user() {
        return "user role";
    }

}
