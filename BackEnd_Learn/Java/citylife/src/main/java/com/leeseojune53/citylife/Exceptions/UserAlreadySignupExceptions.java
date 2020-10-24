package com.leeseojune53.citylife.Exceptions;

public class UserAlreadySignupExceptions extends RuntimeException{

    public UserAlreadySignupExceptions(){
        super("이미 회원가입 하셨습니다.");
    }
}
