package com.example.jwt.Service.User;

import com.example.jwt.Entity.User.User;
import com.example.jwt.Entity.User.UserRepository;
import com.example.jwt.Payload.Response.UserResponse;
import com.example.jwt.Security.Jwt.Auth.AuthDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;


    @Override
    public List<User> show() {
        return userRepository.findAll();
    }

    public UserResponse showmypage(){
        AuthDetail authDetail = (AuthDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return new UserResponse(authDetail.getUserId(), authDetail.getUserPw());
    }
}
