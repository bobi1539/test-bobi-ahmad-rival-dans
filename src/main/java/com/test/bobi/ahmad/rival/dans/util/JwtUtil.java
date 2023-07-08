package com.test.bobi.ahmad.rival.dans.util;

import com.test.bobi.ahmad.rival.dans.dto.GenerateTokenDto;
import com.test.bobi.ahmad.rival.dans.dto.TokenComponentDto;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
public class JwtUtil {

    private final String secretKey = "test-bobi-ahmad-rival-secret-key";

    public GenerateTokenDto generateToken(TokenComponentDto tokenComponentDto){
        Date currentDate = new Date();
        Date validityDate = new Date(currentDate.getTime() + TimeUnit.MINUTES.toMillis(1));

        Map<String, Object> claims = new HashMap<>();
        claims.put("data", tokenComponentDto);

        String token = Jwts.builder()
                .setClaims(claims)
                .setSubject(tokenComponentDto.getUsername())
                .setIssuer("system")
                .setIssuedAt(currentDate)
                .setExpiration(validityDate)
                .signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encode(secretKey.getBytes()))
                .compact();

        return GenerateTokenDto.builder()
                .token(token)
                .validity(validityDate)
                .build();
    }
}
