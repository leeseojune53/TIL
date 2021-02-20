package com.example.entity.security.jwt

import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.GenericFilterBean
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletRequest

class JwtTokenFilter(val jwtTokenProvider: JwtTokenProvider): GenericFilterBean() {


    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain?) {
        request ?: throw Exception()
        val token: String? = jwtTokenProvider.resolveToken(request as HttpServletRequest)
        token?.let {
            if(jwtTokenProvider.validateToken(token)) {
                val auth: Authentication = jwtTokenProvider.authentication(token)
                SecurityContextHolder.getContext().authentication = auth
            }
        }
        chain?.doFilter(request, response)
//        var token: String? = jwtTokenProvider.resolveToken(request as HttpServletRequest)
//        try{
//
//            if (token != null && jwtTokenProvider.validateToken(token)) run {
//                val auth: Authentication = jwtTokenProvider.authentication(token)
//                SecurityContextHolder.getContext().authentication = auth
//            }
//        }

    }
}