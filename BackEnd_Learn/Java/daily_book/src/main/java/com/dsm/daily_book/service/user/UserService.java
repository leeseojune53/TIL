package com.dsm.daily_book.service.user;

import com.dsm.daily_book.dto.UserDTO;
import com.dsm.daily_book.dto.TokenDTO;

public interface UserService {
    void sendAuthCode(UserDTO.mail request);
    void verifyAuthCode(UserDTO.authCode request);
    void register(UserDTO.register request);
    TokenDTO.token auth(UserDTO.auth request);
    void nickname()
}
