package com.example.codeverify.service;

import com.example.codeverify.Payload.AuthCode;
import com.example.codeverify.Payload.EmailRequest;
import com.example.codeverify.Payload.request.Signup;

public interface UserService {
    void sendAuthCode(EmailRequest request);
    void authCode(AuthCode authCode);
    void signup(Signup signup);
}
