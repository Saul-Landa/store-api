package com.slanda.user_service.services;

import com.slanda.user_service.dtos.AuthDTO;

import java.util.Map;

public interface IAuthService {
    String generateToken(String email);
    void validateToken(String token);
    Map<String, String> login(AuthDTO authDTO);
}
