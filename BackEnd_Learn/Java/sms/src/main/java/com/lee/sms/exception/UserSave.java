package com.lee.sms.exception;

import com.lee.sms.error.exception.BusinessException;
import com.lee.sms.error.exception.ErrorCode;

public class UserSave extends BusinessException {
    public UserSave(){
        super(ErrorCode.USER_SAVE);
    }
}
