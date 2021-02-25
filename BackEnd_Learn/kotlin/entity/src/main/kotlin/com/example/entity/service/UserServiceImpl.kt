package com.example.entity.service

import com.example.entity.dto.UserDTO
import com.example.entity.entity.token.TokenRepository
import com.example.entity.entity.user.User
import com.example.entity.entity.user.UserRepository
import com.example.entity.exception.InvalidTokenException
import com.example.entity.security.jwt.JwtTokenProvider
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserServiceImpl (val userRepository: UserRepository,
                       val tokenRepository: TokenRepository,
                       val passwordEncoder: PasswordEncoder,
                       val jwtTokenProvider: JwtTokenProvider,
                       val authenticationManager: AuthenticationManager) : UserService {

    @Value("\${jwt.exp.access}")
    var accessExp: Long = 0

    @Value("\${jwt.exp.refresh}")
    var refreshExp: Long = 0



    override fun register(request: UserDTO.UserInfo) {
        userRepository.save(User(passwordEncoder.encode(request.password), request.name));
    }

    override fun login(request: UserDTO.UserInfo) : UserDTO.Token {
        var user: User = userRepository.findByName(request.name).get()
        var accessToken: String
        var refreshToken: String

        return userRepository.findByName(request.name)
                .filter{ t: User -> passwordEncoder.matches(request.password, t.password) }
                .map { t: User -> t.id }
                .map { t: Int ->
                    try{
                        authenticationManager.authenticate(getAuthToken(t, request.password))
                    }catch (e: Exception){
                        print(e.stackTrace.toString())
                        throw InvalidTokenException()
                    }
                    accessToken = jwtTokenProvider.generateAccessToken(t)
                    refreshToken = jwtTokenProvider.generateRefreshToken(t)
                    //tokenRepository.save(Token(refreshToken, refreshExp * 1000))
                    UserDTO.Token(accessToken, refreshToken, accessExp * 1000)
                 }
                .orElseThrow()


    }

    private fun getAuthToken(id: Int, pwd: String) : UsernamePasswordAuthenticationToken{
        return UsernamePasswordAuthenticationToken(id, pwd)
    }
}