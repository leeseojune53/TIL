package com.example.jwtpractice.Controller;

import com.example.jwtpractice.Entity.User;
import com.example.jwtpractice.Exception.InvaildTokenException;
import com.example.jwtpractice.Exception.UserNotFoundException;
import com.example.jwtpractice.RefreshToken.RefreshToken;
import com.example.jwtpractice.RefreshToken.RefreshTokenRepository;
import com.example.jwtpractice.Repository.UserRepository;
import com.example.jwtpractice.Security.JwtTokenProvider;
import com.example.jwtpractice.payload.Request.LoginRequest;
import com.example.jwtpractice.payload.Request.SignupRequest;
import com.example.jwtpractice.payload.Response.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider tokenProvider;
    private final RefreshTokenRepository refreshTokenRepository;

    @Value("${jwt.prefix}")
    private String tokenType;

    @GetMapping("/login")
    public User Login(@RequestBody LoginRequest loginRequest){
        return userRepository.findByUserId(loginRequest.getUserId())
                .filter(user -> passwordEncoder.matches(loginRequest.getUserPw(), user.getUserPw()))
//                    .map(User::getUsercode)
//                .map(Usercode->{
//                    try{
//                        authenticationManager.authenticate(loginRequest.getAuthToken(Usercode));
//                    }catch (Exception e){
//                        throw new InvaildTokenException();
//                    }
//                    String accessToken = tokenProvider.generateAccessToken(Usercode);
//                    String refreshToken = tokenProvider.generateRefreshToken(Usercode);
//                    refreshTokenRepository.save(new RefreshToken(Usercode, refreshToken));
//                    return new TokenResponse(accessToken, refreshToken, tokenType);
//                })
                .orElseThrow(UserNotFoundException::new);
    }

    @RequestMapping("/signup")
    public void Signup(@RequestBody SignupRequest signupRequest){
        System.out.println(signupRequest);
        userRepository.save(User.builder()
                .userId(signupRequest.getUserId())
                .userPw(signupRequest.getUserPw())
                .build()
        );
    }
}
