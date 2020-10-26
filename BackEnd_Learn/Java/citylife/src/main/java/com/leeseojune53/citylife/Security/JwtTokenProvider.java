package com.leeseojune53.citylife.Security;

import io.jsonwebtoken.Jws;
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


}
