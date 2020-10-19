package com.example.clocky_user.controller;

import com.example.clocky_user.model.User;
import com.example.clocky_user.repository.UserRepository;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/insert")
    public User insert(@RequestBody Map<String, String> map){
        return userRepository.save(
                new User(map.get("name"), Integer.parseInt(map.get("password")))
        );
    }

    @GetMapping(value = "/select/{id}", produces = "application/json")
    public String select(@PathVariable("id") Long id){
        return userRepository.findById(id).orElse(null).toString();
    }
}
