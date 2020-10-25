package com.leeseojune53.citylife.Security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {
    @Value("${jwt.secret}")
    private String secretKey;

    public String createToken(String userId){
        String result =  Jwts.builder()
                .setSubject(userId)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .claim("type", "access_token")
                .compact();

        System.out.println(result);

        return result;
    }

}
