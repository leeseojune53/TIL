package com.example.jwt.Security.Jwt;

import com.example.jwt.Exception.InvalidTokenException;
import com.example.jwt.Security.Jwt.Auth.AuthDetail;
import com.example.jwt.Security.Jwt.Auth.AuthDetailService;
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

    @Value("${jwt.exp.access}")
    private Long accessTokenExpiration;

    @Value("${jwt.exp.refresh}")
    private Long refreshTokenExpiration;

    private final AuthDetailService authDetailService;

    public String GenerateAccessToken(Integer id) {
        return Jwts.builder()
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + accessTokenExpiration * 1000))
                .setSubject(id.toString())
                .claim("type", "access_token")
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public String GenerateRefreshToken(Integer id){

        return Jwts.builder()
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + refreshTokenExpiration * 1000))
                .setSubject(id.toString())
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .claim("type", "RefreshToken")
                .compact();
    }

    public String ResolveToken(HttpServletRequest request){
        String bearer = request.getHeader(header);
        if(bearer != null && bearer.startsWith(prefix)){
            return bearer.substring(7);
        }
        return null;
    }

    public boolean validateToken(String token){
        System.out.println(Jwts.parser().setSigningKey(secretKey)
                .parseClaimsJws(token).getBody().getSubject());
        try{
            Jwts.parser().setSigningKey(secretKey)
                    .parseClaimsJws(token).getBody().getSubject();
            return true;
        }catch(Exception e){
            throw new InvalidTokenException();
        }
    }

    public Authentication authentication(String token){
        AuthDetail authDetail = authDetailService.loadUserByUsername(getid(token));
        return new UsernamePasswordAuthenticationToken(authDetail, "", authDetail.getAuthorities());
    }

    public String getid(String token){
        try{
            return Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
        }catch (Exception e){
            throw new InvalidTokenException();
        }
    }

    public boolean isRefreshToken(String token){
        try{
            return Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token)
                    .getBody()
                    .get("type")
                    .equals("RefreshToken");
        }catch(Exception e){
            throw new InvalidTokenException();
        }
    }

}
