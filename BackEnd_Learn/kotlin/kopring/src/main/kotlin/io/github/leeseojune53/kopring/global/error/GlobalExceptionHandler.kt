package io.github.leeseojune53.kopring.global.error

import io.github.leeseojune53.kopring.global.error.exception.ErrorCode
import io.github.leeseojune53.kopring.global.error.exception.KopringException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(KopringException::class)
    fun handlingKopringException(e: KopringException): ResponseEntity<ErrorResponse> {
        return ResponseEntity(ErrorResponse(e.status, e.errorMessage), HttpStatus.valueOf(e.status))
    }

}