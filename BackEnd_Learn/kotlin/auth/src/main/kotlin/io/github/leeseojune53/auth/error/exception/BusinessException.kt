package io.github.leeseojune53.auth.error.exception

class BusinessException(
    private val errorCode: ErrorCode
): RuntimeException() {
    fun getErrorCode(): ErrorCode {
        return errorCode
    }
}