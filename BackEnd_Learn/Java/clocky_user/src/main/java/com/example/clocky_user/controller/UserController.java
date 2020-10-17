package com.example.clocky_user.controller;

import com.example.clocky_user.model.User;
import com.example.clocky_user.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @RequestMapping("/select/{id}")
    public String select(@PathVariable("id") Long id){
        System.out.println(11);
        System.out.println(userRepository.findById(id).orElse(null).toString());
        return userRepository.findById(id).orElse(null).toString();
    }
}
