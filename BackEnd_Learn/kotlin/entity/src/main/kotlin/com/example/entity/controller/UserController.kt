package com.example.entity.controller

import com.example.entity.dto.UserDTO
import com.example.entity.service.UserService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController (val userService: UserService) {

    @PostMapping("/user/register")
    fun userRegister(@RequestBody request: UserDTO.UserInfo){
        userService.register(request)
    }

    @PostMapping("/user/auth")
    fun userLogin(@RequestBody request: UserDTO.UserInfo){
        userService.login(request)
    }

}