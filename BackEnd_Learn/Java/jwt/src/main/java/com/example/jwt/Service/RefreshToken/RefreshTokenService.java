package com.example.jwt.Service.RefreshToken;

import com.example.jwt.Entity.RefreshToken.RefreshToken;

import java.util.Optional;

public interface RefreshTokenService {
    void save(RefreshToken token);
    Optional<RefreshToken> findRefreshToken(String token);
}
