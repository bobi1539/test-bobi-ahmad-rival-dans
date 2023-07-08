package com.test.bobi.ahmad.rival.dans.util;

import com.test.bobi.ahmad.rival.dans.dto.GenerateTokenDto;
import com.test.bobi.ahmad.rival.dans.dto.TokenComponentDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
public class JwtUtil {

    private final String secretKey = "2B4B6250655368566D597133743677397A244326462948404D635166546A576E";

    public GenerateTokenDto generateToken(TokenComponentDto tokenComponentDto) {
        Date currentDate = new Date();
        Date validityDate = new Date(currentDate.getTime() + TimeUnit.MINUTES.toMillis(60));

        Map<String, Object> claims = new HashMap<>();
        claims.put("data", tokenComponentDto);

        String token = Jwts.builder()
                .setClaims(claims)
                .setSubject(tokenComponentDto.getUsername())
                .setIssuer("system")
                .setIssuedAt(currentDate)
                .setExpiration(validityDate)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();

        return GenerateTokenDto.builder()
                .token(token)
                .validity(validityDate)
                .build();
    }

    public Claims getAllClaims(String token) throws Exception {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean isTokenValid(Date expirationDate) {
        return expirationDate.before(new Date());
    }
}
