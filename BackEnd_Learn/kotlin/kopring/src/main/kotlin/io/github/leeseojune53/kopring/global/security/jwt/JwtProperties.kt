package io.github.leeseojune53.kopring.global.security.jwt

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "jwt")
class JwtProperties(
    val header: String,
    private val exp: Expiration,
    val secret: String,
    val prefix: String,
) {

    companion object {
        const val ACCESS_TYPE = "access"
        const val REFRESH_TYPE = "refresh"
    }

    fun getAccessExp(): Long {
        return exp.access
    }

    fun getRefreshExp(): Long {
        return exp.refresh
    }

}

class Expiration(
    val access: Long,
    val refresh: Long,
)