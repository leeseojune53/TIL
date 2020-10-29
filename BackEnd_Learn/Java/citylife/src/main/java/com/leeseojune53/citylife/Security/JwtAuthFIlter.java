package com.leeseojune53.citylife.Security;

import org.springframework.security.core.Authentication;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class JwtAuthFIlter extends GenericFilterBean {
    private JwtTokenProvider jwtTokenProvider;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String token = jwtTokenProvider.resolve((HttpServletRequest) request);
        if(token!=null && jwtTokenProvider.vaildateToken(token)){
            Authentication authentication = jwtTokenProvider
        }
    }
}
