package com.example.jwt.Service.User;

import com.example.jwt.Entity.User.User;
import com.example.jwt.Entity.User.UserRepository;
import lombok.RequiredArgsConstructor;
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
}
