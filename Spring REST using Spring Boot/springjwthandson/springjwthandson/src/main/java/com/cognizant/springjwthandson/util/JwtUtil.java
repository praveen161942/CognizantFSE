package com.cognizant.springjwthandson.util;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration-in-ms}")
    private long expirationInMs;

    public String generateToken(String username) {
        JwtBuilder builder = Jwts.builder();
        builder.setSubject(username);
        builder.setIssuedAt(new Date());
        builder.setExpiration(new Date((new Date()).getTime() + expirationInMs));
        builder.signWith(SignatureAlgorithm.HS256, secret);
        return builder.compact();
    }
}