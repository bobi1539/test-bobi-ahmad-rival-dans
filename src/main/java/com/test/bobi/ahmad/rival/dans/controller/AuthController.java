package com.test.bobi.ahmad.rival.dans.controller;

import com.test.bobi.ahmad.rival.dans.constant.Operation;
import com.test.bobi.ahmad.rival.dans.dto.response.UserResponse;
import com.test.bobi.ahmad.rival.dans.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AuthController {

    private final UserService userService;

    @GetMapping
    public UserResponse test() {
        return userService.findByUsername("ucup");
    }
}
