package com.leeseojune.awss3.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;

@ControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(MultipartException.class)
//    protected ResponseEntity<ErrorResponse> testHandler(MultipartException e) {
//        return new ResponseEntity<>(new ErrorResponse(200, "No File"), HttpStatus.OK);
//    }

}
