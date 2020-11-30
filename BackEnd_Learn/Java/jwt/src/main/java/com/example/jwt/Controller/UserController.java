package com.example.jwt.Controller;

import com.example.jwt.Entity.User.User;
import com.example.jwt.Payload.Response.UserResponse;
import com.example.jwt.Service.User.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/show/User")
    public List<User> showuser(){
        return userService.show();
    }

    @GetMapping("/show/mypage")
    public UserResponse showmypage(){
        return userService.showmypage();
    }
}
