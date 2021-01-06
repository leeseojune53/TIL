package com.dsm.daily_book.exception.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "UserAlreadyExist")
public class UserAlreadyExistException extends RuntimeException{
    public UserAlreadyExistException(){
        super("UserAlreadyExist");
    }
}
