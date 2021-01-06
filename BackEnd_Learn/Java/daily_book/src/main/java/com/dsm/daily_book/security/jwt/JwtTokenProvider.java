package com.dsm.daily_book.security.jwt;

import com.dsm.daily_book.exception.jwt.InvalidTokenException;
import com.dsm.daily_book.security.jwt.auth.AuthDetails;
import com.dsm.daily_book.security.jwt.auth.AuthDetailsService;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Jwts;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {
    @Value("${jwt.secretkey}")
    private String SECRET_KEY;

    @Value("${jwt.prefix}")
    private String PREFIX;

    @Value("${jwt.header}")
    private String HEADER;

    @Value("${jwt.exp.access}")
    private Long accessExp;

    @Value("${jwt.exp.refresh}")
    private Long refreshExp;

    private final AuthDetailsService authDetailsService;

    public String generateAccessToken(Integer PersonalCode){
        return Jwts.builder()
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + accessExp * 1000))
                .setSubject(PersonalCode.toString())
                .claim("type", "accesstoken")
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public String generateRefreshToken(Integer PersonalCode){
        return Jwts.builder()
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + refreshExp * 1000))
                .setSubject(PersonalCode.toString())
                .claim("type", "refreshtoken")
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public String resolveToken(HttpServletRequest request){
        String bearer = request.getHeader(HEADER);
        if(bearer!=null && bearer.startsWith(PREFIX)){
            return bearer.substring(7);
        }
        return null;
    }

    public boolean validateToken(String token){
        try{
            Jwts.parser()
                .setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();
            return true;
        }catch (Exception e){
            throw new InvalidTokenException();
        }
    }

    public boolean isRefreshToken(String token){
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().get("type").equals("refreshtoken");
    }

    public Authentication authentication(String token){
        AuthDetails authDetails = authDetailsService.loadUserByUsername(getId(token));
        return new UsernamePasswordAuthenticationToken(authDetails, "", authDetails.getAuthorities());
    }

    public String getId(String token){
        try{
            return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();
        }catch(Exception e){
            throw new InvalidTokenException();
        }
    }

}
