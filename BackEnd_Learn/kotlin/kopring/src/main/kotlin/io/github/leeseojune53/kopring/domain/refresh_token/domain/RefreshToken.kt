package io.github.leeseojune53.kopring.domain.refresh_token.domain

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive
import org.springframework.data.redis.core.index.Indexed

@RedisHash
class RefreshToken(
    @Id
    var name: String,

    @Indexed
    var token: String,

    @TimeToLive
    var ttl: Long
) {
    fun update(token: String, ttl: Long): RefreshToken {
        this.token = token
        this.ttl = ttl
        return this
    }
}