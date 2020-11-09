package com.example.jwt.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="User Not Found")

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(){
        super("UserNotFound!!");
        System.out.println("UserNotFound!!");
    }

}
