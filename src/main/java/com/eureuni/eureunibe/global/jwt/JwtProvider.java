package com.eureuni.eureunibe.global.jwt;

import com.eureuni.eureunibe.global.jwt.exception.ExpiredTokenException;
import com.eureuni.eureunibe.global.jwt.exception.InvalidTokenException;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.UUID;

@Component
public class JwtProvider {
    @Value("${jwt.access_secret}")
    private String accessSecret;

    @Value("${jwt.refresh_secret}")
    private String refreshSecret;

    public String generateToken(Long id, String email, boolean isRefreshToken) {
        Instant accessDate = LocalDateTime.now().plusHours(4).atZone(ZoneId.systemDefault()).toInstant();
        Instant refreshDate = LocalDateTime.now().plusDays(30).atZone(ZoneId.systemDefault()).toInstant();
        return Jwts.builder()
                .claim("id", id)
                .setSubject(email)
                .setExpiration(isRefreshToken ? Date.from(refreshDate) : Date.from(accessDate))
                .signWith(SignatureAlgorithm.HS256, isRefreshToken ? refreshSecret : accessSecret)
                .compact();
    }

    public Authentication getAuthentication(String token) {
        Claims claims = parseClaims(token, false);
        Collection<? extends GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority(claims.get("role").toString()));
        return new UsernamePasswordAuthenticationToken(null, authorities);
    }

    public void validateToken(String token, boolean isRefreshToken) {
        try {
            parseClaims(token, isRefreshToken);
        } catch (UnsupportedJwtException | IllegalArgumentException | MalformedJwtException e) {
            throw new InvalidTokenException();
        } catch (ExpiredJwtException e) {
            throw new ExpiredTokenException();
        }
    }

    public Claims parseClaims(String accessToken, boolean isRefreshToken) {
        try {
            JwtParser parser = Jwts.parser().setSigningKey(isRefreshToken ? refreshSecret : accessSecret);
            return parser.parseClaimsJws(accessToken).getBody();
        } catch (ExpiredJwtException e) {
            return e.getClaims();
        }
    }

    public UUID getUserIdFromToken(String token) {
        System.out.println(token);
        Claims claims = parseClaims(token, false);
        return UUID.fromString(claims.get("id").toString());
    }
}