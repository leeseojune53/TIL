package io.github.leeseojune53.kopring.domain.user.service

import io.github.leeseojune53.kopring.domain.user.domain.User
import io.github.leeseojune53.kopring.domain.user.domain.repositories.UserRepository
import io.github.leeseojune53.kopring.domain.user.exception.UserNotFoundException
import io.github.leeseojune53.kopring.domain.user.presentation.dto.request.UserRequest
import io.github.leeseojune53.kopring.domain.user.presentation.dto.response.TokenResponse
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
		private val userRepository: UserRepository,
		private val passwordEncoder: PasswordEncoder,
) {

	fun saveUser(request: UserRequest) {
		userRepository.save(
				User(
						name = request.name,
						password = passwordEncoder.encode(request.password)
				)
		)
	}

}