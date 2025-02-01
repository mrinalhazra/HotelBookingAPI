package com.basicApi.hotel.JWT;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtAuthenticationHelper {

    private String secretKey = "thisisasceretkeygeneratedforsecuritypurposeandtheauthorismrinalhazra";
    private static final long JWT_TOKEN_VALIDITY = 60*60;


    public String getUserNameFromToken(String token){
        String username = getClaimsFromToken(token).getSubject();
        return username;
    }

    public Claims getClaimsFromToken(String token){
        return Jwts.parser()
                .setSigningKey(secretKey.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody();

    }

    public Boolean isTokenExpired(String token){
        Claims claims = getClaimsFromToken(token);
        Date expDate = claims.getExpiration();

        return expDate.before(new Date());
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
         return Jwts.builder().setClaims(claims).setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+JWT_TOKEN_VALIDITY*1000))
                .signWith(new SecretKeySpec(secretKey.getBytes(), SignatureAlgorithm.HS512.getJcaName())
                        ,SignatureAlgorithm.HS512)
                .compact();

    }
}
