package io.github.leeseojune53.kopring.global.security.jwt

import io.github.leeseojune53.kopring.global.security.auth.AuthDetailsService
import io.github.leeseojune53.kopring.global.security.exception.ExpiredTokenException
import io.github.leeseojune53.kopring.global.security.exception.InvalidTokenException
import io.jsonwebtoken.*
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import java.util.*
import javax.servlet.http.HttpServletRequest

@Component
class JwtTokenProvider(
    private val jwtProperties: JwtProperties,
    private val authDetailsService: AuthDetailsService,
) {

    fun generateAccessToken(name: String): String =
        generateToken(name, jwtProperties.getAccessExp(), JwtProperties.ACCESS_TYPE)

    fun generateRefreshToken(name: String): String =
        generateToken(name, jwtProperties.getAccessExp(), JwtProperties.REFRESH_TYPE)

    fun resolveToken(request: HttpServletRequest): String? {
        val bearer: String? = request.getHeader(jwtProperties.header)
        if (bearer != null && bearer.startsWith(jwtProperties.prefix) && bearer.length >= jwtProperties.prefix.length + 1) {
            return bearer.substring(jwtProperties.prefix.length + 1)
        }
        return null
    }

    fun getAuthentication(token: String?): Authentication? {
        return token?.let { it ->
            val claims = getClaims(it)
            val userDetails = authDetailsService.loadUserByUsername(claims.subject)

            return UsernamePasswordAuthenticationToken(userDetails, "", userDetails.authorities)
        }
    }

    private fun getClaims(token: String): Claims {
        return try {
            Jwts.parser().setSigningKey(jwtProperties.secret)
                .parseClaimsJws(token).body
        } catch (e: Exception) {
            when(e) {
                is ExpiredJwtException -> throw ExpiredTokenException.EXCEPTION
                else -> throw InvalidTokenException.EXCEPTION
            }
        }
    }

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