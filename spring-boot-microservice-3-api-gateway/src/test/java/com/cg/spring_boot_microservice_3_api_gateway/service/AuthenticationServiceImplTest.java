package com.cg.spring_boot_microservice_3_api_gateway.service;

import com.cg.spring_boot_microservice_3_api_gateway.model.User;
import com.cg.spring_boot_microservice_3_api_gateway.security.UserPrincipal;
import com.cg.spring_boot_microservice_3_api_gateway.security.jwt.JwtProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AuthenticationServiceImplTest {

    @Mock
    private AuthenticationManager authManager;

    @Mock
    private JwtProvider jwtProvider;

    @Mock
    private Authentication authentication;

    @Mock
    private UserPrincipal userPrincipal;

    @InjectMocks
    private AuthenticationServiceImpl service;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSignInAndReturnJWT() {
        User user = new User();
        user.setUsername("john");
        user.setPassword("pass");

        when(authManager.authenticate(any(UsernamePasswordAuthenticationToken.class))).thenReturn(authentication);
        when(authentication.getPrincipal()).thenReturn(userPrincipal);
        when(userPrincipal.getUser()).thenReturn(user);
        when(jwtProvider.generateToken(userPrincipal)).thenReturn("jwt-token");

        User result = service.signInAndReturnJWT(user);

        assertEquals("jwt-token", result.getToken());
        assertEquals("john", result.getUsername());
    }
}
