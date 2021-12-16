package io.github.leeseojune53.kopring.domain.user.facade

import org.springframework.security.core.context.SecurityContextHolder

class UserFacade {

    fun getCurrentUserName() = SecurityContextHolder.getContext().authentication.name

}