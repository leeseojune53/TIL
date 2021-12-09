package io.github.leeseojune53.kopring.domain.user.exception

import io.github.leeseojune53.kopring.global.error.exception.ErrorCode
import io.github.leeseojune53.kopring.global.error.exception.KopringException

class AlreadyExistNameException private constructor(): KopringException(ErrorCode.ALREADY_EXIST_NAME) {

    companion object {
        val EXCEPTION = AlreadyExistNameException()
    }

}