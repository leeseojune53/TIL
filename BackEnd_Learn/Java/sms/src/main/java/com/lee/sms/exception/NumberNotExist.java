package com.lee.sms.exception;

import com.lee.sms.error.exception.BusinessException;
import com.lee.sms.error.exception.ErrorCode;

public class NumberNotExist extends BusinessException {
    public NumberNotExist(){
        super(ErrorCode.NUMBER_NOT_EXIST);
    }
}
