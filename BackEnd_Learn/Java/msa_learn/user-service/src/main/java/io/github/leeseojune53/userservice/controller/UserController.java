package io.github.leeseojune53.userservice.controller;

import io.github.leeseojune53.userservice.dto.PostResponse;
import io.github.leeseojune53.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestParam(name = "name") String name) {
        userService.register(name);
    }

    @GetMapping("/post")
    public List<PostResponse> getPost(@RequestParam(name = "id") Integer id) {
        return userService.getUserPost(id);
    }

}
