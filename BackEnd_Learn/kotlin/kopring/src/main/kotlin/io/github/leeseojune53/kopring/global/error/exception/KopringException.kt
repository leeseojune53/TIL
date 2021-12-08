package io.github.leeseojune53.kopring.global.error.exception

open class KopringException(
    private val errorCode: ErrorCode
) : RuntimeException() {
    val status: Int
        get() = errorCode.status

    val errorMessage: String
        get() = errorCode.message
}