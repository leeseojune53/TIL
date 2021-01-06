package com.dsm.daily_book.entity.user;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;


@RedisHash
@Getter
@Builder
public class JwtToken {
    @TimeToLive
    private Long ttl;

    @Id
    private String email;

    private String refreshToken;
}
