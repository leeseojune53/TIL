package com.example.codeverify.exception;

public class ExpiredAuthCodeException extends RuntimeException{
    public ExpiredAuthCodeException(){
        super("ExpiredAuthCodeException");
    }
}
