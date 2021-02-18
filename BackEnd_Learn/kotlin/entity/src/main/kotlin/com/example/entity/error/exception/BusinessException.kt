package com.example.entity.error.exception

public open class BusinessException: RuntimeException {

    private var errorCode: ErrorCode

    constructor(message: String?, errorCode: ErrorCode) : super(message) {
        this.errorCode = errorCode
    }

    constructor(errorCode: ErrorCode) : super(errorCode.message){
        this.errorCode = errorCode
    }

}