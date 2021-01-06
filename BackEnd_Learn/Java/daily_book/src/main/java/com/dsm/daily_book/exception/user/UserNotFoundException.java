package com.dsm.daily_book.exception.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "UserNotFound")
public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(){
        super("UserNotFoundException");
    }
}
