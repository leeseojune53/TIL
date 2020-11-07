package com.example.jwt.Exception;

public class InvalidTokenException extends RuntimeException{
    public InvalidTokenException(){
        super("InvaildToken!!");
    }
}
