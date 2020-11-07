package com.example.jwt.Service.RefreshToken;

import com.example.jwt.Entity.RefreshToken.RefreshToken;
import com.example.jwt.Entity.RefreshToken.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RefreshTokenServiceImpl implements RefreshTokenService{

    private final RefreshTokenRepository refreshTokenRepository;

    @Override
    public void save(RefreshToken token) {
        refreshTokenRepository.save(token);
    }
}
