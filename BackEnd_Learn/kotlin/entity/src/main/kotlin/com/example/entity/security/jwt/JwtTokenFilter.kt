package com.example.entity.security.jwt

import org.springframework.web.filter.GenericFilterBean
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletRequest

class JwtTokenFilter(val jwtTokenProvider: JwtTokenProvider): GenericFilterBean() {


    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain?) {
        try{
            var token: String = jwtTokenProvider.resolveToken(request as HttpServletRequest)
            if (token != null && )
        }
    }
}