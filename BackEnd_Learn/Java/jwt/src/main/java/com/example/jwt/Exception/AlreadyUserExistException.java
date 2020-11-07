package com.example.jwt.Exception;

public class AlreadyUserExistException extends RuntimeException{
    public AlreadyUserExistException(){
        super("AlreadyUserExist!!");
    }
}
