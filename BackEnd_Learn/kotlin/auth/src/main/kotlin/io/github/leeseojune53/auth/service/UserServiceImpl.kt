package io.github.leeseojune53.auth.service

import io.github.leeseojune53.auth.dto.UserRegisterRequest
import io.github.leeseojune53.auth.entity.Role
import io.github.leeseojune53.auth.entity.User
import io.github.leeseojune53.auth.entity.UserRepository
import org.springframework.stereotype.Service

@Service
class UserServiceImpl (
    private val userRepository: UserRepository
): UserService {

    override fun register(userRegisterRequest: UserRegisterRequest) {
        val user = User(
            name = userRegisterRequest.name,
            password = userRegisterRequest.password
        )
        user.authorities.add(Role.ROLE_USER)


        userRepository.save(user)
    }

}