package io.github.leeseojune53.querydsl_practice.controller;

import io.github.leeseojune53.querydsl_practice.dto.RegisterRequest;
import io.github.leeseojune53.querydsl_practice.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	@PostMapping("/register")
	public void register(@RequestBody RegisterRequest request) {
		userService.register(request);
	}

	@PostMapping("/signup")
	public String signup(@RequestBody RegisterRequest request) {
		return userService.signUp(request);
	}

}
