package io.github.leeseojune53.kopring.domain.user.service

import io.github.leeseojune53.kopring.domain.user.domain.User
import io.github.leeseojune53.kopring.domain.user.domain.repositories.UserRepository
import io.github.leeseojune53.kopring.domain.user.presentation.dto.request.UserRequest
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

import org.mockito.Mockito.*
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

internal class UserServiceTest {

    private val userRepository: UserRepository = mock(UserRepository::class.java)

    private val passwordEncoder: PasswordEncoder = BCryptPasswordEncoder()

    val userService: UserService = UserService(userRepository, passwordEncoder)

    @Test
    fun saveUser() {
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

}