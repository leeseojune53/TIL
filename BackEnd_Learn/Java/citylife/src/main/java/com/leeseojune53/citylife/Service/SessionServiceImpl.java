package com.leeseojune53.citylife.Service;

import com.leeseojune53.citylife.Entity.User;
import com.leeseojune53.citylife.Payload.Request.LoginRequest;
import com.leeseojune53.citylife.Payload.Response.TokenResponse;
import com.leeseojune53.citylife.Repository.UserRepository;
import com.leeseojune53.citylife.Security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SessionServiceImpl implements SessionService{

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

//    @Override
//    public TokenResponse signIn(LoginRequest request) {
//        return userRepository.findByUserId(request.getUserId())
//                .filter(user -> request.getUserPw().equals(user.getUserPw()))
//                    .map(User::getUserId)
//                .map(userId ->{
//                    String
//                })
//    }

    @Override
    public String CreateToken(LoginRequest request) {
        User user = userRepository.findByUserId(request.getUserId())
                .orElse(null);

        if(!user.getUserPw().equals(request.getUserPw())){
            return null;
        }

        return jwtTokenProvider.createToken(request.getUserId());
    }
}
