package com.acme.application.helpers;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.SignatureException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;

import com.acme.application.exceptions.AccessDeniedException;

public class JwtHelper {
	private static final int MINUTES = 60;
	
	private static final SecretKey secret = Jwts.SIG.HS256.key().build();

	public static String generateToken(String email) {
		var now = Instant.now();
	    return Jwts.builder()
	    		.subject(email)
	    		.issuedAt(Date.from(now))
	    		.expiration(Date.from(now.plus(MINUTES, ChronoUnit.MINUTES)))
	    		.signWith(secret)
	    		.compact();
	}

	public static String extractUsername(String token) {
		return getTokenBody(token).getSubject();
	}

	public static Boolean validateToken(String token, UserDetails userDetails) {
		final String username = extractUsername(token);
		return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
	}

	private static Claims getTokenBody(String token) {
		try {
			return Jwts
					.parser()
					.verifyWith(secret)
					.build()
					.parseSignedClaims(token)
					.getPayload();
		} catch (SignatureException | ExpiredJwtException e) { // Invalid signature or expired token
			throw new AccessDeniedException("Access denied: " + e.getMessage());
		}
	}

	private static boolean isTokenExpired(String token) {
		Claims claims = getTokenBody(token);
		return claims.getExpiration().before(new Date());
	}
}
