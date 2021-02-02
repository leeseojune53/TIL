package com.lee.sms.entity.verify;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

@Getter
@Builder
@RedisHash(timeToLive = 60 * 3)
public class Verify {
    private static final Long MIN = 60L;

    @Id
    private String phone;

    private String number;

    private VerifyStatus status;

    @TimeToLive
    private Long ttl;

    public void verify(){
        this.status = VerifyStatus.VERIFIED;
        ttl = MIN * 3;
    }

    public boolean isVerified(){
        return this.status.equals(VerifyStatus.VERIFIED);
    }
}
