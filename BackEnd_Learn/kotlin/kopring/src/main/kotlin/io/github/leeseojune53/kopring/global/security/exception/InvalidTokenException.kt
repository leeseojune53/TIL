package io.github.leeseojune53.kopring.global.security.exception

import io.github.leeseojune53.kopring.global.error.exception.ErrorCode
import io.github.leeseojune53.kopring.global.error.exception.KopringException

class InvalidTokenException private constructor(): KopringException(ErrorCode.INVALID_TOKEN) {

    companion object {
        val EXCEPTION = InvalidTokenException()
    }

}