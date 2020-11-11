package com.example.jwt.Service.Auth;

import com.example.jwt.Entity.RefreshToken.RefreshToken;
import com.example.jwt.Entity.User.User;
import com.example.jwt.Entity.User.UserRepository;
import com.example.jwt.Exception.InvalidTokenException;
import com.example.jwt.Exception.UserNotFoundException;
import com.example.jwt.Payload.Request.LoginRequest;
import com.example.jwt.Payload.Response.TokenResponse;
import com.example.jwt.Security.Jwt.JwtTokenProvider;
import com.example.jwt.Service.RefreshToken.RefreshTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    @Value("${jwt.exp.access}")
    private Long accessTokenExpiration;

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final RefreshTokenService refreshTokenService;

    @Override
    public TokenResponse signIn(LoginRequest request) {
        return userRepository.findByUserId(request.getUserId())
                .filter(user -> passwordEncoder.matches(request.getUserPw(), user.getUserPw()))
                .map(User::getId)
                .map(id -> {
                    try{
                        authenticationManager.authenticate(request.getAuthToken(id));
                    }catch (Exception e){
                        throw new InvalidTokenException();
                    }
                    String accesstoken = jwtTokenProvider.GenerateAccessToken(id);
                    String refreshtoken = jwtTokenProvider.GenerateRefreshToken(id);
                    refreshTokenService.save(new RefreshToken(id, refreshtoken));
                    return new TokenResponse(accesstoken, refreshtoken, accessTokenExpiration.toString());
                })
                .orElseThrow(UserNotFoundException::new);
    }

    @Override
    public TokenResponse refreshToken(String receivedToken) {
        if(!jwtTokenProvider.isRefreshToken(receivedToken))
            throw new InvalidTokenException();
        return refreshTokenService.findRefreshToken(receivedToken)
                .map(refreshToken->{
                    String generatedRefreshToken = jwtTokenProvider.GenerateRefreshToken(refreshToken.getId());
                    String generatedAccessToken = jwtTokenProvider.GenerateAccessToken(refreshToken.getId());
                    refreshTokenService.save(new RefreshToken(refreshToken.getId(), generatedRefreshToken));
                    return new TokenResponse(generatedAccessToken, generatedRefreshToken, accessTokenExpiration.toString());
                })
                .orElseThrow(InvalidTokenException::new);
    }
}
