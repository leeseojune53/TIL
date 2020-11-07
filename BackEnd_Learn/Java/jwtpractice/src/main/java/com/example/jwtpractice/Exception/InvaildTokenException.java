package com.example.jwtpractice.Exception;

public class InvaildTokenException extends RuntimeException{
    public InvaildTokenException(){
        super("InvaildTokenException");
    }
}
