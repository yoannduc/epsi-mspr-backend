package com.acme.application.helpers;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;

import com.acme.application.exceptions.AccessDeniedException;

public class JwtHelper {
	private static String secret = "bXlzdXBlcnNlY3JldAo=";

	private static final int MINUTES = 60;
	
	private static SecretKey getSigningKey() {
		byte[] keyBytes = Decoders.BASE64.decode(secret);
		return Keys.hmacShaKeyFor(keyBytes);
	}

	public static String generateToken(String email) {
		var now = Instant.now();
	    return Jwts.builder()
	    		.subject(email)
	    		.issuedAt(Date.from(now))
	    		.expiration(Date.from(now.plus(MINUTES, ChronoUnit.MINUTES)))
	    		//.signWith(getSigningKey())
	    		.signWith(Jwts.SIG.HS256.key().build())
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
					//.verifyWith(getSigningKey())
					.verifyWith(Jwts.SIG.HS256.key().build())
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
