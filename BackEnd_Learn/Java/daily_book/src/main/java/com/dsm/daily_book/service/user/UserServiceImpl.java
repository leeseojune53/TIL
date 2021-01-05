package com.dsm.daily_book.service.user;

import com.dsm.daily_book.dto.request.User;
import com.dsm.daily_book.entity.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Override
    public void register(User.register request) {

    }

    @Override
    public void auth(User.auth request) {

    }
}
