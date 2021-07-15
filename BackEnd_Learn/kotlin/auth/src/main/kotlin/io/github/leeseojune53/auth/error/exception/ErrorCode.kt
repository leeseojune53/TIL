package io.github.leeseojune53.auth.error.exception

import com.fasterxml.jackson.annotation.JsonFormat

@JsonFormat(shape = JsonFormat.Shape.STRING)
enum class ErrorCode(
    private val statusCode: Int,
    private val message: String
) {
    USER_NOT_FOUND(404, "User not found.");

    fun getStatusCode(): Int {
        return statusCode
    }

    fun getMessage(): String {
        return message
    }

}