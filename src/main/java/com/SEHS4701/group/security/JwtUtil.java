package com.SEHS4701.group.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
@Component
public class JwtUtil {
    private final String secret = "ThisIsAVerySecureSecretKeyThatIsAtLeast32BytesLong1234567890"; // Should be 32+ characters
    private int expirationMs = 86400000; // 24 hours in milliseconds
    private final SecretKey key = Keys.hmacShaKeyFor(secret.getBytes());

    public String generateToken(String username) {
        Instant now = Instant.now();
        Instant expirationInstant = now.plus(expirationMs, ChronoUnit.MILLIS);

        return Jwts.builder()
                .subject(username)
                .issuedAt(Date.from(now))              // Convert Instant to Date
                .expiration(Date.from(expirationInstant)) // Convert Instant to Date
                .signWith(key)
                .compact();
    }

    public String getUsernameFromToken(String token) {
        return Jwts.parser()
                .verifyWith(key) // Updated: Use verifyWith instead of setSigningKey
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                    .verifyWith(key) // Updated: Use verifyWith instead of setSigningKey
                    .build()
                    .parseSignedClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}