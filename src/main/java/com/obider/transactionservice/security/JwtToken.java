package com.obider.transactionservice.security;

import com.obider.transactionservice.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

import static com.obider.transactionservice.security.SecurityConstants.API_SECRET_KEY;
import static com.obider.transactionservice.security.SecurityConstants.TOKEN_VALIDITY;

public class JwtToken {
    public static String generate(User user){
        long timestamp = System.currentTimeMillis();
        String token = Jwts.builder().signWith(SignatureAlgorithm.HS256, API_SECRET_KEY)
                .setIssuedAt(new Date(timestamp))
                .setExpiration(new Date(timestamp+TOKEN_VALIDITY))
                .claim("userId",user.getId())
                .compact();
        return token;
    }

    public static String getClaim(String token){
        Claims claims = Jwts.parser().setSigningKey(API_SECRET_KEY)
                .parseClaimsJws(token).getBody();
        return claims.get("userId").toString();
    }
}
