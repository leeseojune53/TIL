package com.leeseojune53.citylife.Service;

import com.leeseojune53.citylife.Entity.User;
import com.leeseojune53.citylife.Exceptions.UserAlreadySignupExceptions;
import com.leeseojune53.citylife.Payload.Request.SignRequest;
import com.leeseojune53.citylife.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SignupServiceImpl implements SignupService {
    private final UserRepository userRepository;

    @Override
    public boolean userSignupService(SignRequest request) {
        try{
            userRepository.save(
                    User.builder()
                        .userId(request.getUserId())
                        .nickname(request.getNickname())
                        .userPw(request.getUserPw())
                        .build()
            );
            return true;
        }catch (Exception e){
            throw new UserAlreadySignupExceptions();
        }
    }

    @Override
    public boolean isAlreadySignupService(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.isEmpty();
    }
}
