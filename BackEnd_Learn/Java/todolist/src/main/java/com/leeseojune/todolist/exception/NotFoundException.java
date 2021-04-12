package com.leeseojune.todolist.exception;

import com.leeseojune.todolist.error.excetion.BusinessException;
import com.leeseojune.todolist.error.excetion.ErrorCode;

public class NotFoundException extends BusinessException {
    public NotFoundException(){
        super(ErrorCode.NOT_FOUND);
    }
}
