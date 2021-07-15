package io.github.leeseojune53.auth.error

class ErrorResponse(
    private val status: Int,
    private val message: String
) {
    fun getStatus(): Int{
        return status
    }

    fun getMessage(): String {
        return message
    }
}