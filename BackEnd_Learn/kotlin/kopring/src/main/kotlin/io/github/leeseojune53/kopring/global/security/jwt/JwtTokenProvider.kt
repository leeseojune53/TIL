package io.github.leeseojune53.kopring.global.security.jwt

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component
import java.util.*

@Component
class JwtTokenProvider(
    private val jwtProperties: JwtProperties,
) {

    fun generateAccessToken(name: String): String =
        generateToken(name, jwtProperties.getAccessExp(), JwtProperties.ACCESS_TYPE)

    fun generateRefreshToken(name: String): String =
        generateToken(name, jwtProperties.getAccessExp(), JwtProperties.REFRESH_TYPE)

    private fun generateToken(name: String, exp: Long, typ: String): String {
        return Jwts.builder()
            .setSubject(name)
            .setIssuedAt(Date())
            .signWith(SignatureAlgorithm.HS256, jwtProperties.secret)
            .setExpiration(Date(System.currentTimeMillis() + exp * 1000))
            .setHeaderParam("typ", typ)
            .compact()
    }

}