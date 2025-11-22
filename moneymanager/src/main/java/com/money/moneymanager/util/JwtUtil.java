package com.money.moneymanager.util;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.function.Function;

@Component
public class JwtUtil {

    // Secret key for signing the JWT (keep it safe, normally from application.properties)
//    private final String SECRET_KEY = "mySecretKeyForJwt123"; // change to a stronger secret

    @Value("${jwt.secret}")
    private String SECRET_KEY;
    // Token validity (e.g., 24 hours)
    private final long JWT_EXPIRATION = 1000 * 60 * 60 * 24;

    // Generate token using email as subject
    public String generateToken(String email) {
        return Jwts.builder()
                .setSubject(email) // subject is the username/email
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + JWT_EXPIRATION))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    // Extract username/email from token
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    // Extract expiration date
    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    // Extract any claim using a resolver function
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    // Check if token is expired
    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }



    // Validate token (check username and expiration)
    public Boolean validateToken(String token, UserDetails userDetails) { // Parameter ka naam bhi theek kar lete hain
        final String username = extractUsername(token);
        // UserDetails object se username nikal kar compare karein
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    // Parse all claims
    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }
}
