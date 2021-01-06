package com.dsm.daily_book.exception.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "ExpiredAuthCodeException")
public class ExpiredAuthCodeException extends RuntimeException{
    public ExpiredAuthCodeException(){
        super("ExpiredAuthCodeException");
    }
}
