package com.example.entity.security.jwt

import com.example.entity.exception.InvalidTokenException
import com.example.entity.security.jwt.auth.AuthDetails
import com.example.entity.security.jwt.auth.AuthDetailsService
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import java.util.*
import javax.servlet.http.HttpServletRequest

@Component
class JwtTokenProvider(private val authDetailsService: AuthDetailsService) {

    @Value("\${jwt.header}")
    var header: String? = null

    @Value("\${jwt.prefix}")
    var prefix: String = ""

    @Value("\${jwt.secret}")
    var secret: String = ""

    @Value("\${jwt.exp.access}")
    var accessExp: Long = 0L

    @Value("\${jwt.exp.refresh}")
    var refreshExp: Long = 0L

    fun generateAccessToken(id: Int): String{
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, getSigningKey())
                .setHeaderParam("typ", "JWT")
                .setSubject(id.toString())
                .claim("type", "access")
                .setIssuedAt(Date())
                .setExpiration(Date(System.currentTimeMillis() + accessExp * 1000))
                .compact()
    }

    fun generateRefreshToken(id: Int): String{
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, getSigningKey())
                .setHeaderParam("typ", "JWT")
                .setSubject(id.toString())
                .claim("type", "refresh")
                .setIssuedAt(Date())
                .setExpiration(Date(System.currentTimeMillis() + refreshExp * 1000))
                .compact()
    }

    fun resolveToken(request: HttpServletRequest) : String?{
        val bearer: String= request.getHeader(header)
        if(bearer.startsWith(prefix)){
            if(bearer.length>7){
                return bearer.substring(7)
            }else throw InvalidTokenException()
        }
        return null
    }

    fun validateToken(token:String) : Boolean{
        return try{
            Jwts.parser().parseClaimsJws(token).body.subject
            true
        }catch (e: Exception){
            false
        }
    }

    fun authentication(token: String) : Authentication{
        val authDetails: AuthDetails = authDetailsService.loadUserByUsername(getId(token))
        return UsernamePasswordAuthenticationToken(authDetails, "", authDetails.authorities)
    }

    private fun getId(token: String) : String{
        return try{
            Jwts.parser()
                    .setSigningKey(getSigningKey()).parseClaimsJws(token).body.subject
        }catch (e: Exception){
            throw InvalidTokenException()
        }
    }

    private fun getSigningKey() : String{
        return Base64.getEncoder().encodeToString(secret.encodeToByteArray())
    }

}