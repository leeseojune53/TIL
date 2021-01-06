package com.dsm.daily_book.exception.email;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "InvalidAuthEmailException")
public class InvalidAuthEmailException extends RuntimeException{
    public InvalidAuthEmailException(){
        super("InvalidAuthEmailException");
    }
}
