package com.example.jwtpractice.Exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(){
        super("UserNotFound!!");
    }
}
