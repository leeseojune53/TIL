package com.dsm.daily_book.exception.email;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "InvalidAuthCodeException")
public class InvalidAuthCodeException extends RuntimeException{
    public InvalidAuthCodeException(){
        super("InvalidAuthCodeException");
    }
}
