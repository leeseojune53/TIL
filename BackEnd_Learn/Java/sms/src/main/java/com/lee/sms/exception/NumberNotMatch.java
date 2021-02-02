package com.lee.sms.exception;

import com.lee.sms.error.exception.BusinessException;
import com.lee.sms.error.exception.ErrorCode;

public class NumberNotMatch extends BusinessException {
    public NumberNotMatch(){
        super(ErrorCode.NUMBER_NOT_EXIST);
    }
}
