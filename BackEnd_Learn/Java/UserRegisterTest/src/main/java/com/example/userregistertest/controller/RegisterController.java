package com.example.userregistertest.controller;

import com.example.userregistertest.model.User;
import com.example.userregistertest.repository.UserRepository;
import com.example.userregistertest.request.RegisterRequest;
import com.example.userregistertest.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/User")
@RequiredArgsConstructor
public class RegisterController {
    private final RegisterService userRegister;

    @PostMapping("/register")
    public boolean userregister(@RequestBody RegisterRequest request){
        return userRegister.userRegisterService(request);
    }

    @GetMapping("/get/{id}")
    public User selectOne(@PathVariable("id") long id){
        return userRegister.getUser(id);
    }
}
