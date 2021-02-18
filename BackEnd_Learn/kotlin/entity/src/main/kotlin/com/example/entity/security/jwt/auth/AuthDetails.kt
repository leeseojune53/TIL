package com.example.entity.security.jwt.auth

import com.example.entity.entity.user.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*
import kotlin.collections.ArrayList

class AuthDetails(val user: Optional<User>): UserDetails {


    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return ArrayList<GrantedAuthority>()
    }

    override fun isEnabled(): Boolean {
        return true
    }

    override fun getUsername(): String {
        return user.name
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun getPassword(): String {
        return ""
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }
}