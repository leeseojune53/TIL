package com.leeseojune53.citylife.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Overlap")
public class UserAlreadySignupExceptions extends RuntimeException{
    public UserAlreadySignupExceptions(){
        super("아이디중복.");
    }
}
