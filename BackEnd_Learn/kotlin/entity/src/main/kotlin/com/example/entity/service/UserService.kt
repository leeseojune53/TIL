package com.example.entity.service

import com.example.entity.dto.UserDTO

interface UserService {
    fun register(request: UserDTO.UserInfo)
    fun login(request: UserDTO.UserInfo)
}