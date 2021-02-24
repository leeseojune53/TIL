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
        return user
                .map { t: User -> t.name }.get()
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun getPassword(): String {
        return user
                .map { t: User -> t.password }.get()
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }
}