package com.leeseojune53.citylife.Service;

import com.leeseojune53.citylife.Payload.Request.LoginRequest;
import com.leeseojune53.citylife.Payload.Response.TokenResponse;

import javax.servlet.http.HttpServletRequest;

public interface SessionService {
    //public TokenResponse signIn(LoginRequest request);
    public String CreateToken(LoginRequest request);
}
