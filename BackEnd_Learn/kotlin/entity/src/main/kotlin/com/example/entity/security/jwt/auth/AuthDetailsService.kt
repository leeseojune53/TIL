package com.example.entity.security.jwt.auth

import com.example.entity.entity.user.UserRepository
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class AuthDetailsService(val userRepository: UserRepository): UserDetailsService {
    override fun loadUserByUsername(id: String): AuthDetails {
        return userRepository.findById(id.toInt())?.let {
            AuthDetails(it) }?: throw UsernameNotFoundException("$id Can Not Found")
    }
}