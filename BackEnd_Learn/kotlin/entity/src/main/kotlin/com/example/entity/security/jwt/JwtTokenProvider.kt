package com.example.entity.security.jwt

import com.example.entity.exception.InvalidTokenException
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties
import javax.servlet.http.HttpServletRequest

class JwtTokenProvider {

    @Value("\${jwt.header}")
    var header: String? = null

    @Value("\${jwt.prefix}")
    var prefix: String = ""

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
        try{
            O
        }
    }

}