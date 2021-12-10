package io.github.leeseojune53.kopring.domain.user.service

import io.github.leeseojune53.kopring.domain.refresh_token.domain.RefreshToken
import io.github.leeseojune53.kopring.domain.refresh_token.domain.repositories.RefreshTokenRepository
import io.github.leeseojune53.kopring.domain.user.domain.User
import io.github.leeseojune53.kopring.domain.user.domain.repositories.UserRepository
import io.github.leeseojune53.kopring.domain.user.exception.AlreadyExistNameException
import io.github.leeseojune53.kopring.domain.user.exception.InvalidPasswordException
import io.github.leeseojune53.kopring.domain.user.exception.TokenNotFoundException
import io.github.leeseojune53.kopring.domain.user.exception.UserNotFoundException
import io.github.leeseojune53.kopring.domain.user.presentation.dto.request.UserRequest
import io.github.leeseojune53.kopring.domain.user.presentation.dto.response.TokenResponse
import io.github.leeseojune53.kopring.global.security.jwt.JwtProperties
import io.github.leeseojune53.kopring.global.security.jwt.JwtTokenProvider
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class UserService(
    private val userRepository: UserRepository,
    private val refreshTokenRepository: RefreshTokenRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtTokenProvider: JwtTokenProvider,
    private val jwtProperties: JwtProperties,
) {

    fun saveUser(request: UserRequest) {
        userRepository.findByName(request.name)?.let { throw AlreadyExistNameException.EXCEPTION }

        userRepository.save(
            User(
                name = request.name,
                password = passwordEncoder.encode(request.password)
            )
        )
    }

    fun login(request: UserRequest): TokenResponse {
        val user: User = userRepository.findByName(request.name)
            ?: throw UserNotFoundException.EXCEPTION

        if (!passwordEncoder.matches(request.password, user.password))
            throw InvalidPasswordException.EXCEPTION

        val accessToken = jwtTokenProvider.generateAccessToken(user.name)
        val refreshToken = jwtTokenProvider.generateRefreshToken(user.name)
        refreshTokenRepository.save(
            RefreshToken(
                name = user.name,
                token = refreshToken,
                ttl = jwtProperties.getRefreshExp()
            )
        )
        return TokenResponse(accessToken, refreshToken)

    }

    @Transactional
    fun tokenRefresh(token: String): TokenResponse {
        val refreshTokenEntity = refreshTokenRepository.findByToken(token)
            ?: throw TokenNotFoundException.EXCEPTION

        val accessToken = jwtTokenProvider.generateAccessToken(refreshTokenEntity.name)
        val refreshToken = jwtTokenProvider.generateRefreshToken(refreshTokenEntity.name)

        refreshTokenEntity.update(refreshToken, jwtProperties.getRefreshExp())

        return TokenResponse(accessToken, refreshToken)
    }

}