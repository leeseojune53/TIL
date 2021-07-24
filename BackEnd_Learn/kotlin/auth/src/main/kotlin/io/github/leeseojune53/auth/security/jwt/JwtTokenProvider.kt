package io.github.leeseojune53.auth.security.jwt

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.*
import javax.servlet.http.HttpServletRequest

@Component
class JwtTokenProvider {

    @Value("jwt.secret")
    private lateinit var secretKey: String

    @Value("jwt.access.exp")
    private var accessExp: Long = 0

    fun generateAccessToken(id: String) : String {
        return Jwts.builder()
            .signWith(SignatureAlgorithm.HS256, secretKey)
            .setHeaderParam("typ", "JWT")
            .claim("type", "access")
            .setSubject(id)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + 6000 * 1000))
            .compact()
    }

    fun resolveToken(httpServletRequest: HttpServletRequest): String {

        var bearer = httpServletRequest.getHeader("Authorization");
        if(bearer != null && bearer.toString())
    }

}