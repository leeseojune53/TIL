package com.lee.sms.error;

import com.lee.sms.error.exception.BusinessException;
import com.lee.sms.error.exception.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<ErrorResponse> handleBusinessException(BusinessException e){
        final ErrorCode errorCode = e.getErrorCode();
        log.warn("BusinessException : " + e);

        return new ResponseEntity<>(new ErrorResponse(errorCode.getStatus(), errorCode.getMessage()),
                HttpStatus.valueOf(errorCode.getStatus()));
    }
}
