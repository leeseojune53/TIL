package com.dsm.daily_book.controller;

import com.dsm.daily_book.dto.UserDTO;
import com.dsm.daily_book.dto.TokenDTO;
import com.dsm.daily_book.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @PatchMapping("/nickname")
    public void nickname(@RequestBody UserDTO.changeNickname request){
        userService.changeNickname(request);
    }
}
