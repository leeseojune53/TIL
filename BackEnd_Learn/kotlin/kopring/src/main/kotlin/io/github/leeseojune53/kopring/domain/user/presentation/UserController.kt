package io.github.leeseojune53.kopring.domain.user.presentation

import io.github.leeseojune53.kopring.domain.user.presentation.dto.request.UserRequest
import io.github.leeseojune53.kopring.domain.user.presentation.dto.response.TokenResponse
import io.github.leeseojune53.kopring.domain.user.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    private val userService: UserService,
) {

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    fun signUp(@RequestBody request: UserRequest) {
        userService.saveUser(request)
    }

    @PostMapping("/login")
    fun signIn(@RequestBody request: UserRequest): TokenResponse {
        return userService.login(request)
    }

}