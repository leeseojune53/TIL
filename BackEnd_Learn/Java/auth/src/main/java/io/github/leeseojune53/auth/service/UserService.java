package io.github.leeseojune53.auth.service;

import io.github.leeseojune53.auth.dto.UserAuthRequest;
import io.github.leeseojune53.auth.dto.UserRegisterRequest;

public interface UserService {
    void userRegister(UserRegisterRequest registerRequest);
    String getAccessToken(UserAuthRequest authRequest);
}
