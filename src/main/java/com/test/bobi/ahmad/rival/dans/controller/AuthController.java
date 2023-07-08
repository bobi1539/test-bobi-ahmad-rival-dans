package com.test.bobi.ahmad.rival.dans.controller;

import com.test.bobi.ahmad.rival.dans.constant.Operation;
import com.test.bobi.ahmad.rival.dans.dto.request.AuthDtoRequest;
import com.test.bobi.ahmad.rival.dans.dto.response.AuthDtoResponse;
import com.test.bobi.ahmad.rival.dans.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public AuthDtoResponse login(@RequestBody AuthDtoRequest request){
        return authService.auth(request);
    }

    @GetMapping("/test")
    public Operation test(){
        return Operation.INSERTED;
    }
}
