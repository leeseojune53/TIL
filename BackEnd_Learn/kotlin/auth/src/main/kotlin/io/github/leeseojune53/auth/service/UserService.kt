package io.github.leeseojune53.auth.service

import io.github.leeseojune53.auth.dto.UserRegisterRequest

interface UserService {
    fun register(userRegisterRequest: UserRegisterRequest)
}