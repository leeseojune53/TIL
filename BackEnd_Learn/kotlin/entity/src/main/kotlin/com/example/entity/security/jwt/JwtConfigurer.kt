package com.example.entity.security.jwt

import org.springframework.security.config.annotation.SecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.DefaultSecurityFilterChain
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

class JwtConfigurer(val jwtTokenProvider: JwtTokenProvider): SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>(), WebMvcConfigurer {
    override fun configure(builder: HttpSecurity?) {

    }
}