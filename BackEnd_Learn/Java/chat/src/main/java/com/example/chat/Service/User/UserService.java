package com.example.chat.Service.User;

import com.example.chat.Payload.Request.UserRequest;
import com.example.chat.Payload.Response.TokenResponse;

public interface UserService {
    public void register(UserRequest request);
    public TokenResponse auth(UserRequest request);
}
