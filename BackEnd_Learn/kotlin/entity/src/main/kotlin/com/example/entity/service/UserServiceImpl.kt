package com.example.entity.service

import com.example.entity.dto.UserDTO
import com.example.entity.entity.user.User
import com.example.entity.entity.user.UserRepository
import com.example.entity.exception.InvalidTokenException
import com.example.entity.security.jwt.JwtTokenProvider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class UserServiceImpl (val userRepository: UserRepository,
                       val passwordEncoder: PasswordEncoder,
                       val jwtTokenProvider: JwtTokenProvider,
                       val authenticationManager: AuthenticationManager) : UserService {


    override fun register(request: UserDTO.UserInfo) {
        userRepository.save(User(passwordEncoder.encode(request.password), request.name));
    }

    override fun login(request: UserDTO.UserInfo) {
        var user: User = userRepository.findByName(request.name).get()


        userRepository.findByName(request.name)
                .filter{ t: User -> passwordEncoder.matches(request.password, t.password) }
                .map { t: User -> t.id }
                .map { t: Int ->
                    try{
                        authenticationManager.authenticate(getAuthToken(t, request.password))
                    }catch (e: Exception){
                        print(e.stackTrace.toString())
                        throw InvalidTokenException()
                    }
                    val accessToken: String = jwtTokenProvider.generateAccessToken(t);
                    println(accessToken)
                 }
                .orElseThrow()
    }

    private fun getAuthToken(id: Int, pwd: String) : UsernamePasswordAuthenticationToken{
        return UsernamePasswordAuthenticationToken(id, pwd)
    }
}