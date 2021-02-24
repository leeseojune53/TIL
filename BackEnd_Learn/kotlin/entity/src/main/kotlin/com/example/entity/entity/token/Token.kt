package com.example.entity.entity.token

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType

@RedisHash("")
class User(
        @Id
        val token: String? = null,
        @TimeToLive
        val ttl: Long? = null
)
