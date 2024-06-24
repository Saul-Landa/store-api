package com.slanda.user_service.controllers;

import com.slanda.user_service.dtos.AuthDTO;
import com.slanda.user_service.services.IAuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AuthController {
    private final IAuthService authService;

    public AuthController(IAuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody AuthDTO authDTO) {
        return authService.login(authDTO);
    }
}
