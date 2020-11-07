package com.example.jwt.Exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(){
        super("UserNotFound!!");
    }
}
