package com.test.bobi.ahmad.rival.dans.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.bobi.ahmad.rival.dans.constant.GlobalMessage;
import com.test.bobi.ahmad.rival.dans.dto.BusinessException;
import com.test.bobi.ahmad.rival.dans.util.JwtUtil;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class JwtFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {
        log.info("request uri : {}", request.getRequestURI());

        final String authHeader = request.getHeader("Authorization");
        if (Objects.isNull(authHeader) || !authHeader.startsWith("Bearer")) {
            throw new BusinessException(GlobalMessage.UNAUTHORIZED);
        }

//        final String jwtToken = authHeader.substring(7);
//        try {
//            Claims claims = jwtUtil.getAllClaims(jwtToken);
//            boolean isTokenExpired = jwtUtil.isTokenExpired(claims.getExpiration());
//            if (isTokenExpired) {
//                throw new BusinessException(GlobalMessage.UNAUTHORIZED);
//            }
//        } catch (Exception e) {
//            throw new BusinessException(GlobalMessage.UNAUTHORIZED);
//        }

        filterChain.doFilter(request, response);
    }
}
