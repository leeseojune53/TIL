package com.example.jwt.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "AlreadyUserExist!!")
public class AlreadyUserExistException extends RuntimeException{
    public AlreadyUserExistException(){
        super("AlreadyUserExist!!");
    }
}
