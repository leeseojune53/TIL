package com.lee.sms.error.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    NUMBER_NOT_EXIST(404, "verify number not exist."),
    EXPIRED_AUTH_CODE(400, "verify was expired."),
    USER_SAVE(500, "User Save Error."),
    NUMBER_NOT_MATCH(400, "verify number not match");

    private final int status;
    private final String message;
}
