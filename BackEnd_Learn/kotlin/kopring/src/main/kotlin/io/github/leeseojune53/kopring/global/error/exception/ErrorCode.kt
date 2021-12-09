package io.github.leeseojune53.kopring.global.error.exception

import com.fasterxml.jackson.annotation.JsonFormat

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
enum class ErrorCode(
    val status: Int,
    val message: String
) {

    USER_NOT_FOUND(400, "User not found."),
    ALREADY_EXIST_NAME(400, "Already exist name."),
    INVALID_PASSWORD(400, "Invalid password."),
    EXPIRED_TOKEN(401, "Expired token."),
    INVALID_TOKEN(401, "Invalid token")

}