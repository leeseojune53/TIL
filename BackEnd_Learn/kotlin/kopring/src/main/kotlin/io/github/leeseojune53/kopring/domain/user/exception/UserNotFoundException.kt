package io.github.leeseojune53.kopring.domain.user.exception

import io.github.leeseojune53.kopring.global.error.exception.ErrorCode
import io.github.leeseojune53.kopring.global.error.exception.KopringException

class UserNotFoundException private constructor() : KopringException(ErrorCode.USER_NOT_FOUND) {
	companion object{
		@JvmField
		val EXCEPTION = UserNotFoundException()
	}
}