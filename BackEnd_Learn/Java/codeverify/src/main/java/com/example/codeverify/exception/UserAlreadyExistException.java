package com.example.codeverify.exception;

public class UserAlreadyExistException extends RuntimeException{
    public UserAlreadyExistException(){
        super("UserAlreadyExistException");
    }
}
