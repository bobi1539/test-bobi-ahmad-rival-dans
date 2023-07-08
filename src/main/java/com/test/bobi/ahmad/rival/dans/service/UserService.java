package com.test.bobi.ahmad.rival.dans.service;

import com.test.bobi.ahmad.rival.dans.dto.response.UserDtoResponse;

public interface UserService {
    UserDtoResponse findByUsername(String username);
}
