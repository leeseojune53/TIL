package com.example.jwtpractice.Security;

import com.example.jwtpractice.Exception.InvaildTokenException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.prefix}")
    private String prefix;

    @Value("${jwt.header}")
    private String header;

    //@Value("${jwt.exp.access}")
    private Long accessTokenExpiration = 60*2L;

    //@Value("${jwt.exp.refresh}")
    private Long refreshTokenExpiration = 60*60*2L;

    private final AuthDetailsService authDetailsService;


    public String generateAccessToken(Integer usercode){
        return Jwts.builder()
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + accessTokenExpiration * 1000))
                .setSubject(usercode.toString())
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .claim("type", "access_token")
                .compact();
    }

    public String generateRefreshToken(Integer usercode){
        return Jwts.builder()
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + refreshTokenExpiration * 1000))
                .setSubject(usercode.toString())
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .claim("type", "refresh_token")
                .compact();
    }

    public String resolveToken(HttpServletRequest request){
        String bearerToken = request.getHeader(header);
        if(bearerToken!=null && bearerToken.startsWith(prefix)){
            return bearerToken.substring(7);
        }
        return null;
    }

    public boolean vaildateToken(String token){
        try {
            Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
            return true;
        }catch (Exception e){
            throw new InvaildTokenException();
        }
    }

    public Authentication getAuthentication(String token){
        AuthDetails authDetails = authDetailsService.loadUserByUsername(getusercode(token));
        return new UsernamePasswordAuthenticationToken(authDetails, "", authDetails.getAuthorities());
    }

    public String getusercode(String token){
        try{
            return Jwts.parser().setSigningKey(secretKey)
                    .parseClaimsJws(token).getBody().getSubject();
        }catch (Exception e){
            throw new InvaildTokenException();
        }
    }


}
