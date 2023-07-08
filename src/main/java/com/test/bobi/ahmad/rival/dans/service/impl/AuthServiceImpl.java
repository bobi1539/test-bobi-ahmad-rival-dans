package com.test.bobi.ahmad.rival.dans.service.impl;

import com.test.bobi.ahmad.rival.dans.UserRepository;
import com.test.bobi.ahmad.rival.dans.constant.GlobalMessage;
import com.test.bobi.ahmad.rival.dans.dto.BusinessException;
import com.test.bobi.ahmad.rival.dans.dto.GenerateTokenDto;
import com.test.bobi.ahmad.rival.dans.dto.TokenComponentDto;
import com.test.bobi.ahmad.rival.dans.dto.request.AuthDtoRequest;
import com.test.bobi.ahmad.rival.dans.dto.response.AuthDtoResponse;
import com.test.bobi.ahmad.rival.dans.entity.MUser;
import com.test.bobi.ahmad.rival.dans.service.AuthService;
import com.test.bobi.ahmad.rival.dans.util.JwtUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    @Override
    public AuthDtoResponse auth(AuthDtoRequest request) {
        MUser user = userRepository.findByUsername(request.getUsername()).orElseThrow(
                () -> new BusinessException(GlobalMessage.UNAUTHORIZED)
        );

        boolean passwordIsValid = BCrypt.checkpw(request.getPassword(), user.getPassword());
        if(!passwordIsValid){
            throw new BusinessException(GlobalMessage.UNAUTHORIZED);
        }

        TokenComponentDto tokenComponentDto = TokenComponentDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .build();
        GenerateTokenDto generateTokenDto = jwtUtil.generateToken(tokenComponentDto);
        return AuthDtoResponse.builder()
                .token(generateTokenDto.getToken())
                .validity(generateTokenDto.getValidity())
                .build();
    }
}
