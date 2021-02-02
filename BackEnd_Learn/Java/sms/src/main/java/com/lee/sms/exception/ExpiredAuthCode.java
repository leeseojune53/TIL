package com.lee.sms.exception;

import com.lee.sms.error.exception.BusinessException;
import com.lee.sms.error.exception.ErrorCode;

public class ExpiredAuthCode extends BusinessException {
    public ExpiredAuthCode(){
        super(ErrorCode.EXPIRED_AUTH_CODE);
    }
}
