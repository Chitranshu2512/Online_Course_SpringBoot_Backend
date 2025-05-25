package com.cg.spring_boot_microservice_3_api_gateway.controller;

import com.cg.spring_boot_microservice_3_api_gateway.model.User;
import com.cg.spring_boot_microservice_3_api_gateway.service.AuthenticationService;
import com.cg.spring_boot_microservice_3_api_gateway.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AuthenticationControllerTest {

    @InjectMocks
    private AuthenticationController controller;

    @Mock
    private AuthenticationService authenticationService;

    @Mock
    private UserService userService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSignUp_UserExists_ReturnsConflict() {
        User user = new User();
        user.setUsername("john");
        when(userService.findByUsername("john")).thenReturn(Optional.of(user));

        ResponseEntity<?> response = controller.signUp(user);
        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
    }

    @Test
    public void testSignUp_NewUser_ReturnsCreated() {
        User user = new User();
        user.setUsername("john");
        when(userService.findByUsername("john")).thenReturn(Optional.empty());
        when(userService.saveUser(user)).thenReturn(user);

        ResponseEntity<?> response = controller.signUp(user);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(user, response.getBody());
    }

    @Test
    public void testSignIn_ReturnsOk() {
        User user = new User();
        user.setUsername("john");
        User jwtUser = new User();
        jwtUser.setUsername("john");
        jwtUser.setToken("token");

        when(authenticationService.signInAndReturnJWT(user)).thenReturn(jwtUser);

        ResponseEntity<?> response = controller.signIn(user);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("token", ((User) response.getBody()).getToken());
    }
}