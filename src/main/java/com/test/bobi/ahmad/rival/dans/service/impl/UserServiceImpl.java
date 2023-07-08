package com.test.bobi.ahmad.rival.dans.service.impl;

import com.test.bobi.ahmad.rival.dans.UserRepository;
import com.test.bobi.ahmad.rival.dans.constant.GlobalMessage;
import com.test.bobi.ahmad.rival.dans.dto.BusinessException;
import com.test.bobi.ahmad.rival.dans.dto.response.UserDtoResponse;
import com.test.bobi.ahmad.rival.dans.entity.MUser;
import com.test.bobi.ahmad.rival.dans.service.UserService;
import com.test.bobi.ahmad.rival.dans.util.BeanMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDtoResponse findByUsername(String username) {
        MUser user = userRepository.findByUsername(username).orElseThrow(
                () -> new BusinessException(GlobalMessage.DATA_NOT_FOUND)
        );
        return BeanMapper.map(user, UserDtoResponse.class);
    }
}
