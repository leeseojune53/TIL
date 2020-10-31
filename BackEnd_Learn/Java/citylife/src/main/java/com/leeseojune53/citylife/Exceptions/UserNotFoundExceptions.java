package com.leeseojune53.citylife.Exceptions;

public class UserNotFoundExceptions extends RuntimeException{
    private static final long serialVersionUID = -3205057992054017970L;

    public UserNotFoundExceptions(){
        super("User is Not Found.");
    }
}
