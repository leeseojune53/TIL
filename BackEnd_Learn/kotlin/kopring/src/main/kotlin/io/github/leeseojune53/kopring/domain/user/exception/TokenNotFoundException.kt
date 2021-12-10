package io.github.leeseojune53.kopring.domain.user.exception

import io.github.leeseojune53.kopring.global.error.exception.ErrorCode
import io.github.leeseojune53.kopring.global.error.exception.KopringException

class TokenNotFoundException private constructor(): KopringException(ErrorCode.TOKEN_NOT_FOUND) {

    companion object {
        val EXCEPTION = TokenNotFoundException()
    }

}