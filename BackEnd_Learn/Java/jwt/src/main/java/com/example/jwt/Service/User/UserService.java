package com.example.jwt.Service.User;

import com.example.jwt.Entity.User.User;
import com.example.jwt.Payload.Response.UserResponse;

import java.util.List;

public interface UserService {
    List<User> show();
    public UserResponse showmypage();
}
