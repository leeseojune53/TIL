package com.example.userregistertest.service;

import com.example.userregistertest.model.User;
import com.example.userregistertest.request.RegisterRequest;

import java.util.List;

public interface RegisterService {
    public boolean userRegisterService(RegisterRequest request);
    public User getUser(long id);
    public Iterable<User> getUsers();
}
