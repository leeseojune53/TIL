package io.github.leeseojune53.auth.exception;

import io.github.leeseojune53.auth.error.exception.BusinessException;
import io.github.leeseojune53.auth.error.exception.ErrorCode;

public class UserNotFoundException extends BusinessException {
    public UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
