package com.dsm.daily_book.service.user;

import com.dsm.daily_book.dto.request.UserDTO;
import com.dsm.daily_book.dto.response.TokenDTO;

public interface UserService {
    void sendAuthCode(UserDTO.mail request);
    void verifyAuthCode(UserDTO.authCode request);
    void register(UserDTO.register request);
    TokenDTO.token auth(UserDTO.auth request);
}
