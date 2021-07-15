package io.github.leeseojune53.auth.entity

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.stream.Collectors
import javax.persistence.*


@Entity
class User(
    @Id
    private var name: String,
    private var password: String,
    @Enumerated(EnumType.STRING)
    @Column
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "role", joinColumns = arrayOf(JoinColumn(name = "name")))
    private var roles : MutableList<Role>
): UserDetails {
    override fun getAuthorities(): MutableCollection<GrantedAuthority> {
        val rolesToString = roles.stream().map { obj: Role -> obj.name }.collect(Collectors.toList())
        return rolesToString.stream().map { role: String -> SimpleGrantedAuthority(role) }.collect(Collectors.toList())
    }

    override fun getPassword(): String {
        return this.password
    }

    override fun getUsername(): String {
        return this.name
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }

    constructor(name: String, password: String) : this(name, password, null!!)
}