package com.example.clocky_user.controller;

import com.example.clocky_user.model.User;
import com.example.clocky_user.repository.UserRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping("/User")
@RestController
public class UserController {
    public final UserRepository userRepository;

    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @RequestMapping("/insert")
    public User insert(@RequestBody Map<String, String> map){
        return userRepository.save(
                new User(map.get("name"), Integer.parseInt(map.get("password")))
        );
    }
}
