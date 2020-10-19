package com.example.userregistertest.service;

import com.example.userregistertest.model.User;
import com.example.userregistertest.repository.UserRepository;
import com.example.userregistertest.request.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserRegisterImpl implements RegisterService {
    private final UserRepository userRepository;

    @Override
    public boolean userRegisterService(RegisterRequest request) {
            userRepository.save(
                    User.builder()
                    .name(request.getName())
                    .password(request.getPassword())
                    .build()
            );
        return true;
    }

    @Override
    public User getUser(long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }


}
