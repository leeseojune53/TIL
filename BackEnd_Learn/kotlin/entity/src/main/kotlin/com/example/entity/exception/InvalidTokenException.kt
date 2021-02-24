package com.example.entity.exception

import com.example.entity.error.exception.BusinessException
import com.example.entity.error.exception.ErrorCode

class InvalidTokenException : BusinessException(ErrorCode.INVALID_TOKEN)