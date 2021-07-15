package io.github.leeseojune53.auth.error

import io.github.leeseojune53.auth.error.exception.BusinessException
import io.github.leeseojune53.auth.error.exception.ErrorCode
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice


@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(value = [(BusinessException::class)])
    fun handleBusinessException(
        exception: BusinessException
    ) : ResponseEntity<ErrorResponse> {
        val errorCode: ErrorCode = exception.getErrorCode()

        return ResponseEntity<ErrorResponse>(
            ErrorResponse(errorCode.getStatusCode(), errorCode.getMessage()),
            HttpStatus.valueOf(errorCode.getStatusCode())
        )
    }


}