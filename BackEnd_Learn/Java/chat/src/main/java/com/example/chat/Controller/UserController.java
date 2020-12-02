package com.example.chat.Controller;

import com.example.chat.Payload.Request.UserRequest;
import com.example.chat.Payload.Response.TokenResponse;
import com.example.chat.Service.User.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final ChatController chatController;

    @PostMapping("/register")
    public void Register(@RequestBody UserRequest request){
        userService.register(request);
    }

    @PostMapping("/auth")
    public TokenResponse auth(@RequestBody UserRequest request){
        System.out.println(request.getUserId() + "\t" + request.getUserPw());
        chatController.chat();
        return userService.auth(request);
    }
}
