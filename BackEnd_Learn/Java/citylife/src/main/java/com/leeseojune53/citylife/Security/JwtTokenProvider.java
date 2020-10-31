package com.leeseojune53.citylife.Security;

import com.leeseojune53.citylife.Service.auth.AuthDetails;
import com.leeseojune53.citylife.Service.auth.AuthDetailsService;
import io.jsonwebtoken.Jws;
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
    private final AuthDetailsService authDetailsService;

    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.prefix}")
    private String prefix;

    @Value("${jwt.header}")
    private String header;

    public String createToken(String userId){
        String result =  Jwts.builder()
                .setSubject("UserToken")
                .setHeaderParam("type", "JWT")
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .claim("userId", userId)
                .setExpiration(new Date(System.currentTimeMillis() + 30*1000))
                .compact();

        System.out.println(result);

        return result;
    }

//    public boolean vaildationToken(String jwt){
//        if(jwt!=null){
//            String userkey = this.getuserId(jwt);
//        }
//    }

    public String getuserId(String jwt) throws RuntimeException{
        try {
            Jws Claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwt);
            System.out.println("t" + Claims.getBody()+"");
            return Claims.getBody()+"";
        }catch (Exception e){
            return "RuntimeException";
        }
    }

    public boolean vaildateToken(String token){
        try {
            Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJwt(token).getBody().getSubject();
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public String resolve(HttpServletRequest request){
        String bearerToken = request.getHeader(header);
        if(bearerToken!=null&&bearerToken.startsWith(prefix))
            return bearerToken.substring(7);
        return null;
    }

    public Authentication getAuthentication(String userId){
        AuthDetails authDetails = authDetailsService.loadUserByUsername(userId);
        return new UsernamePasswordAuthenticationToken(authDetails, "", authDetails.getAuthorities());
    }

}
