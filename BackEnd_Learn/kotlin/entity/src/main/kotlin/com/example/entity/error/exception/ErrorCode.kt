package com.example.entity.error.exception

enum class ErrorCode(i: Int, s: String) {

    INVALID_TOKEN(401, "Invalid Token");


    val status: Int = 0
    val message: String = ""
}