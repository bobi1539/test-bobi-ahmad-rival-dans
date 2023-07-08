package com.test.bobi.ahmad.rival.dans.service;

import com.test.bobi.ahmad.rival.dans.dto.request.AuthDtoRequest;
import com.test.bobi.ahmad.rival.dans.dto.response.AuthDtoResponse;

public interface AuthService {
    AuthDtoResponse auth(AuthDtoRequest request);
}
