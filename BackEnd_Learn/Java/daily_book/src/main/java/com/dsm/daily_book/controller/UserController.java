package com.dsm.daily_book.controller;

import com.dsm.daily_book.dto.request.UserDTO;
import com.dsm.daily_book.dto.response.TokenDTO;
import com.dsm.daily_book.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/verify")
    public void mail(@RequestBody UserDTO.mail request){
        userService.sendAuthCode(request);
    }

    @PutMapping("/verify")
    public void verifyCode(@RequestBody UserDTO.authCode request){
        userService.verifyAuthCode(request);
    }

    @PostMapping("/register")
    public void register(@RequestBody UserDTO.register request){
        userService.register(request);
    }

    @PostMapping("/auth")
    public TokenDTO.token auth(@RequestBody UserDTO.auth request){
        return userService.auth(request);
    }
}
