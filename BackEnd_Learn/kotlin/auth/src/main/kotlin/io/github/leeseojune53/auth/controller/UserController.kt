package io.github.leeseojune53.auth.controller

import io.github.leeseojune53.auth.dto.UserRegisterRequest
import io.github.leeseojune53.auth.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController


@RestController
class UserController(
    private val userService: UserService
) {

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    fun register(@RequestBody userRegisterRequest: UserRegisterRequest) {
        userService.register(userRegisterRequest)
    }

}