package com.cinemamanagementsoftware.authenticationservice;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class JwtUtil {
    private static final SecretKey secretKey = Jwts.SIG.HS256.key().build();
    private static final long expirationTime = 3600000;  // 1 hour in milliseconds
    
    private static final Set<String> invalidatedTokens = ConcurrentHashMap.newKeySet();
    
    public static String generateToken(String email) {
        Instant now = Instant.now();
        return Jwts.builder()
            .subject(email)
            .issuedAt(Date.from(now))
            .expiration(Date.from(Instant.now().plusMillis(expirationTime)))
            .signWith(secretKey, Jwts.SIG.HS256)
            .compact();
    }

    public static String extractEmail(String token) {
        return Jwts.parser()
            .verifyWith(secretKey)
            .build()
            .parseSignedClaims(token)
            .getPayload()
            .getSubject();
    }
    
    public static boolean validateToken(String token) {
        try {
            if (invalidatedTokens.contains(token)) {
                return false;  // Token has been invalidated
            }

            Claims claims = Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();

            return claims.getExpiration().after(new Date());  // Ensure token is not expired
        } catch (JwtException | IllegalArgumentException e) {
            return false;  // Invalid token
        }
    }
    
    public static void invalidateToken(String token) {
        invalidatedTokens.add(token);
    }
}