package com.slanda.user_service.services.Implements;

import com.slanda.user_service.dtos.AuthDTO;
import com.slanda.user_service.services.IAuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService implements IAuthService {
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthService(JwtService jwtService, AuthenticationManager authenticationManager) {
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public String generateToken(String email) {
        return jwtService.generateToken(email);
    }

    @Override
    public void validateToken(String token) {
        jwtService.validateToken(token);
    }

    @Override
    public Map<String, String> login(AuthDTO authDTO) {
        UsernamePasswordAuthenticationToken usernameAuthentication = new UsernamePasswordAuthenticationToken(authDTO.getUsername(), authDTO.getPassword());
        Authentication authenticate = authenticationManager.authenticate(usernameAuthentication);
        boolean isAuthenticated = authenticate.isAuthenticated();

        Map<String, String> result = new HashMap<>();
        result.put("token", isAuthenticated ? generateToken(authDTO.getUsername()) : "");
        result.put("message", isAuthenticated ? "" : "Invalid access");

        return result;
    }
}
