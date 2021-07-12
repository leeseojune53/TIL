package io.github.leeseojune53.auth.security.jwt;

import io.github.leeseojune53.auth.security.auth.AuthDetailsService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    @Value("${jwt.secret}")
    private String secretKey;

    private final AuthDetailsService authDetailsService;

    public String generateAccessToken(String id) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, getSigningKey())
                .setHeaderParam("typ", "JWT")
                .claim("type", "access")
                .setSubject(id)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 6000 * 1000))
                .compact();
    }

    public String resolveToken(HttpServletRequest httpServletRequest) {
        String bearer = httpServletRequest.getHeader("Authorization");
        if(bearer != null && bearer.startsWith("Bearer"))
            return bearer.substring(7);
        return null;
    }

    public boolean validateToken(String token) {
        return getTokenBody(token).getExpiration()
                .after(new Date());
    }

    public Authentication authentication(String token) {
        UserDetails userDetails = authDetailsService.loadUserByUsername(getId(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    private Claims getTokenBody(String token) {
        return Jwts.parser().setSigningKey(getSigningKey())
                .parseClaimsJws(token).getBody();
    }

    private String getId(String token) {
        return getTokenBody(token).getSubject();
    }

    private String getSigningKey() {
        return Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

}
