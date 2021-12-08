package io.github.leeseojune53.kopring.domain.user.exception

import io.github.leeseojune53.kopring.global.error.exception.ErrorCode
import io.github.leeseojune53.kopring.global.error.exception.KopringException

class InvalidPasswordException private constructor(): KopringException(ErrorCode.INVALID_PASSWORD) {

    companion object {
        val EXCEPTION = InvalidPasswordException()
    }

}