package com.test.bobi.ahmad.rival.dans.service;

import com.test.bobi.ahmad.rival.dans.dto.response.UserResponse;

public interface UserService {
    UserResponse findByUsername(String username);
}
