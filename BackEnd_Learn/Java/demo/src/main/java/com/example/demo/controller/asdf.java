package com.example.demo.controller;

import com.example.demo.Payload.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;

@RequestMapping(value = "/member")
@RestController
public class asdf {
    @GetMapping("/user")
    public User userTest() {
        return new User("leeseojune","1234!@#$");
    }

    @GetMapping("/users")
    public ArrayList<User> memberTest(){
        return new ArrayList(Arrays.asList(
                new User("leeseojune","1234"),
                new User("chinese","1234qwer"),
                new User("unun","hi")
        ));
    }

    @GetMapping("/a")
    public String test(){
        return "hello";
    }
}
