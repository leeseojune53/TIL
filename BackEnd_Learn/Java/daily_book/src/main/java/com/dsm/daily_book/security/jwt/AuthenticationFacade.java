package com.dsm.daily_book.security.jwt;

import com.dsm.daily_book.entity.user.User;
import com.dsm.daily_book.security.jwt.auth.AuthDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFacade {

    public Authentication getAuthentication(){
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public User getUser(){
        return ((AuthDetails)getAuthentication().getPrincipal()).getUser();
    }

}
