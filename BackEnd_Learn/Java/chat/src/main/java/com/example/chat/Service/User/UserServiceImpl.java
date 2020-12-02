package com.example.chat.Service.User;

import com.example.chat.Entity.RefreshToken.RefreshToken;
import com.example.chat.Entity.RefreshToken.RefreshTokenRepository;
import com.example.chat.Entity.User.User;
import com.example.chat.Entity.User.UserRepository;
import com.example.chat.Payload.Request.UserRequest;
import com.example.chat.Payload.Response.TokenResponse;
import com.example.chat.Security.Jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;
    private final RefreshTokenRepository refreshTokenRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void register(UserRequest request) {
        userRepository.save(
                User.builder()
                .userId(request.getUserId())
                .userPw(passwordEncoder.encode(request.getUserPw()))
                .build()
        );
    }

    @Override
    public TokenResponse auth(UserRequest request) {
        return userRepository.findByUserId(request.getUserId())
                .filter(user-> passwordEncoder.matches(request.getUserPw(), user.getUserPw()))
                .map(User::getUserCode)
                .map(userCode->{
                    try{
                        authenticationManager.authenticate(request.getAuthToken(userCode));
                    }catch (Exception e){
                        throw new RuntimeException();
                    }
                    String accessToken = jwtTokenProvider.generateAccessToken(userCode);
                    String refreshToken = jwtTokenProvider.generateRefreshToken(userCode);
                    String key = "user:" + userCode;
                    refreshTokenRepository.save(new RefreshToken(userCode, refreshToken));
//                    redisUtilService.setDataExpire(key, refreshToken, RefreshToken_exp);
                    return new TokenResponse(accessToken, refreshToken);
                })
                .orElseThrow(RuntimeException::new);
    }
}
