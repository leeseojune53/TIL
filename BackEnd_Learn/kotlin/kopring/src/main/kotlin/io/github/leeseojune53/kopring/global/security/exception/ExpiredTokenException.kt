package io.github.leeseojune53.kopring.global.security.exception

import io.github.leeseojune53.kopring.global.error.exception.ErrorCode
import io.github.leeseojune53.kopring.global.error.exception.KopringException

class ExpiredTokenException private constructor(): KopringException(ErrorCode.EXPIRED_TOKEN) {

    companion object {
        val EXCEPTION = ExpiredTokenException()
    }

}