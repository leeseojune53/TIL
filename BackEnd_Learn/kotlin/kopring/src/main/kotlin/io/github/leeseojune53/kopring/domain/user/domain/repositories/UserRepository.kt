package io.github.leeseojune53.kopring.domain.user.domain.repositories

import io.github.leeseojune53.kopring.domain.user.domain.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long> {
	fun findByName(name: String): User?
}