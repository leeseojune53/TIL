package io.github.leeseojune53.auth.security.auth

import io.github.leeseojune53.auth.entity.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService

class AuthDetailsService(
    private val userRepository: UserRepository
): UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        return userRepository.findById(username)
                    .orElseThrow()
    }
}