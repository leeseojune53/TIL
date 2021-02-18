package com.example.entity.dto

class UserDTO {

    class UserInfo(var name: String, var password: String){
        init { }
    }

    class Token(var accessToken: String, var refreshToken: String, var exp: Long){
        init { }
    }

}