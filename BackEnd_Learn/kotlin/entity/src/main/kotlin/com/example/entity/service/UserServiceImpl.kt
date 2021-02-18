package com.example.entity.service

import com.example.entity.dto.UserDTO
import com.example.entity.entity.user.User
import com.example.entity.entity.user.UserRepository
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserServiceImpl (val userRepository: UserRepository, val passwordEncoder: PasswordEncoder) : UserService {


    override fun register(request: UserDTO.UserInfo) {
        userRepository.save(User(request.name, passwordEncoder.encode(request.password)));
    }

    override fun login(request: UserDTO.UserInfo) {
        userRepository.findByName(request.name)
                .map { t: User -> passwordEncoder.matches(request.password, t.password) }
    }
}