package com.example.awsses;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Controller {
    private final UserService userService;

    @RequestMapping("/")
    public void sendMail(){
        userService.sendMail();
    }
}
