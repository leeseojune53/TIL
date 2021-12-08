package io.github.leeseojune53.kopring.domain.user.service

import io.github.leeseojune53.kopring.domain.user.domain.User
import io.github.leeseojune53.kopring.domain.user.domain.repositories.UserRepository
import io.github.leeseojune53.kopring.domain.user.exception.InvalidPasswordException
import io.github.leeseojune53.kopring.domain.user.exception.UserNotFoundException
import io.github.leeseojune53.kopring.domain.user.presentation.dto.request.UserRequest
import io.github.leeseojune53.kopring.domain.user.presentation.dto.response.TokenResponse
import io.github.leeseojune53.kopring.global.security.jwt.JwtTokenProvider
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtTokenProvider: JwtTokenProvider,
) {

    fun saveUser(request: UserRequest) {
        userRepository.save(
            User(
                name = request.name,
                password = passwordEncoder.encode(request.password)
            )
        )
        userRepository.findByName(request.name)
    }

    fun login(request: UserRequest): TokenResponse {
        val user: User = userRepository.findByName(request.name)
            ?: throw UserNotFoundException.EXCEPTION

        if (passwordEncoder.matches(request.password, user.password)) {
            //generate token
            val accessToken = jwtTokenProvider.generateAccessToken(user.name)
            val refreshToken = jwtTokenProvider.generateRefreshToken(user.name)
            print(refreshToken)
            return TokenResponse(accessToken, refreshToken)
        } else throw InvalidPasswordException.EXCEPTION
    }

}