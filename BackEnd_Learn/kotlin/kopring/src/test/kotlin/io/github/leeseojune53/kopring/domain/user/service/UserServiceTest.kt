package io.github.leeseojune53.kopring.domain.user.service

import io.github.leeseojune53.kopring.domain.refresh_token.domain.repositories.RefreshTokenRepository
import io.github.leeseojune53.kopring.domain.user.domain.User
import io.github.leeseojune53.kopring.domain.user.domain.repositories.UserRepository
import io.github.leeseojune53.kopring.domain.user.exception.AlreadyExistNameException
import io.github.leeseojune53.kopring.domain.user.exception.InvalidPasswordException
import io.github.leeseojune53.kopring.domain.user.exception.UserNotFoundException
import io.github.leeseojune53.kopring.domain.user.presentation.dto.request.UserRequest
import io.github.leeseojune53.kopring.global.security.auth.AuthDetailsService
import io.github.leeseojune53.kopring.global.security.jwt.JwtProperties
import io.github.leeseojune53.kopring.global.security.jwt.JwtTokenProvider
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

import org.mockito.Mockito.*
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

internal class UserServiceTest {

    private val userRepository: UserRepository = mock(UserRepository::class.java)

    private val refreshTokenRepository: RefreshTokenRepository = mock(RefreshTokenRepository::class.java)

    private val passwordEncoder: PasswordEncoder = BCryptPasswordEncoder()

    private val jwtProperties: JwtProperties = mock(JwtProperties::class.java)

    private val authDetailsService = AuthDetailsService(userRepository)

    private val jwtTokenProvider: JwtTokenProvider = JwtTokenProvider(jwtProperties, authDetailsService)

    private val userService: UserService =
        UserService(userRepository, refreshTokenRepository, passwordEncoder, jwtTokenProvider, jwtProperties)

    @Test
    fun 유저_회원가입_성공() {
        //given
        var savedUser: User? = null
        val name = "Testname"
        val password = "TestPW"
        val userRequest = UserRequest(name, password)

        //when
        `when`(userRepository.save(any(User::class.java))).then { invocation ->
            savedUser = invocation.arguments[0] as User
            savedUser
        }
        userService.saveUser(userRequest)

        //then
        assertNotNull(savedUser)
    }

    @Test
    fun 유저_회원가입_실패() {
        //given
        val name = "Test"
        val password = "pw"
        val userRequest = UserRequest(name = name, password = password)
        val user = User(name = name, password = password)

        //when
        `when`(userRepository.findByName(name)).thenReturn(user)

        //then
        assertThrows(AlreadyExistNameException::class.java) {
            userService.saveUser(userRequest)
        }
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

    @Test
    fun 로그인_실패_유저_없음() {
        //given
        val name = "Testname"
        val password = "TestPW"
        val request = UserRequest(name, password)

        //when
        `when`(jwtProperties.getAccessExp())
            .thenReturn(1000)
        `when`(jwtProperties.getRefreshExp())
            .thenReturn(1000)
        `when`(jwtProperties.secret)
            .thenReturn("test")

        //then
        assertThrows(UserNotFoundException::class.java) {
            userService.login(request)
        }
    }

    @Test
    fun 로그인_실패_잘못된_비밀번호() {
        //given
        val name = "Testname"
        val password = "TestPW"
        val user = User(name = name, password = passwordEncoder.encode(password + "I"))
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

        //then
        assertThrows(InvalidPasswordException::class.java) {
            userService.login(request)
        }
    }

}