package io.github.leeseojune53.kopring.domain.user.service

import io.github.leeseojune53.kopring.domain.user.domain.User
import io.github.leeseojune53.kopring.domain.user.domain.repositories.UserRepository
import io.github.leeseojune53.kopring.domain.user.presentation.dto.request.UserRequest
import io.github.leeseojune53.kopring.global.security.jwt.JwtProperties
import io.github.leeseojune53.kopring.global.security.jwt.JwtTokenProvider
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

import org.mockito.Mockito.*
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

internal class UserServiceTest {

    private val userRepository: UserRepository = mock(UserRepository::class.java)

    private val passwordEncoder: PasswordEncoder = BCryptPasswordEncoder()

    private val jwtProperties: JwtProperties = mock(JwtProperties::class.java)

    private val jwtTokenProvider: JwtTokenProvider = JwtTokenProvider(jwtProperties)

    private val userService: UserService = UserService(userRepository, passwordEncoder, jwtTokenProvider)

    @Test
    fun 유저_회원가입() {
        //given
        var savedUser: User? = null
        val name = "Testname"
        val password = "TestPW"
        val userRequest = UserRequest(name, password)

        //when
        `when`(userRepository.save(any(User::class.java))).thenAnswer { invocation ->
            savedUser = invocation.arguments[0] as User
            invocation.arguments[0]
        }
        userService.saveUser(userRequest)

        //then
        assertNotNull(savedUser)
    }

    @Test
    fun 로그인_성공() {
        //given
        val name = "Testname"
        val password = "TestPW"
        val user = User(name = name, password = passwordEncoder.encode(password))
        val request = UserRequest(name, password)

        //when
        `when`(userRepository.findByName(name))
            .thenReturn(user)
        `when`(jwtProperties.getAccessExp())
            .thenReturn(1000)
        `when`(jwtProperties.getRefreshExp())
            .thenReturn(1000)
        `when`(jwtProperties.secret)
            .thenReturn("test")

        val response = userService.login(request)

        //then
        assertNotNull(response.accessToken)
        assertNotNull(response.refreshToken)
    }

}