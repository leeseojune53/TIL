package io.github.leeseojune53.kopring.domain.refresh_token.domain.repositories

import io.github.leeseojune53.kopring.domain.refresh_token.domain.RefreshToken
import org.springframework.data.repository.CrudRepository

interface RefreshTokenRepository: CrudRepository<RefreshToken, String> {
}