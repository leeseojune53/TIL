package com.example.jwt.Service.Signup;

import com.example.jwt.Entity.User.User;
import com.example.jwt.Entity.User.UserRepository;
import com.example.jwt.Exception.AlreadyUserExistException;
import com.example.jwt.Payload.Request.SignupRequest;
import com.example.jwt.Payload.Response.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignupServiceImpl implements SignupService{
    private final UserRepository userRepository;

    @Override
    public LoginResponse signup(SignupRequest request) {
        try{
            User user = User.builder()
                    .userId(request.getUserId())
                    .userPw(request.getUserPw())
                    .build();
            userRepository.save(user);
            return new LoginResponse(true, user);
        }catch (Exception e){
            throw new AlreadyUserExistException();
        }
    }
}
