package com.test.bobi.ahmad.rival.dans.filter;

import com.test.bobi.ahmad.rival.dans.constant.GlobalMessage;
import com.test.bobi.ahmad.rival.dans.dto.BusinessException;
import com.test.bobi.ahmad.rival.dans.util.JwtUtil;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("request uri : {}", request.getRequestURI());

        String authHeader = request.getHeader("Authorization");
        if(Objects.isNull(authHeader) || !authHeader.startsWith("Bearer")){
            throw new BusinessException(GlobalMessage.UNAUTHORIZED);
        }

        String token = authHeader.substring(7);
        Claims claims;
        try {
            claims = jwtUtil.getAllClaims(token);
        } catch (Exception e) {
            throw new BusinessException(GlobalMessage.UNAUTHORIZED);
        }

        boolean isTokenValid = jwtUtil.isTokenValid(claims.getExpiration());
        if(!isTokenValid){
            throw new BusinessException(GlobalMessage.UNAUTHORIZED);
        }

        filterChain.doFilter(request, response);
    }
}
