package com.dsm.daily_book.service.user;

import com.dsm.daily_book.dto.request.User;

public interface UserService {
    void register(User.register request);
    void auth(User.auth request);
}
