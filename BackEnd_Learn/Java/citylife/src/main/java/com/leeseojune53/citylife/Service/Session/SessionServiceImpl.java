package com.leeseojune53.citylife.Service.Session;

import com.leeseojune53.citylife.Entity.User;
import com.leeseojune53.citylife.Payload.Request.LoginRequest;
import com.leeseojune53.citylife.Security.JwtTokenProvider;
import com.leeseojune53.citylife.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SessionServiceImpl implements SessionService{

    private final com.leeseojune53.citylife.Repository.UserRepository
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

        User user = userRepository.findByUserId(request.getUserId()).orElse(null);
        if(user == null)
            return "존재하지 않은 아이디 입니다.";
        System.out.println(user.getUserId());
        if(!user.getUserPw().equals(request.getUserPw())){
            return "틀린 비밀번호 입니다.";
        }

        return jwtTokenProvider.createToken(request.getUserId());
    }

    @Override
    public List<User> rank() {
        return userRepository.findTop3ByOrderByUserIdDesc();
    }
}
