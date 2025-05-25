package com.cg.spring_boot_microservice_3_api_gateway.service;

import com.cg.spring_boot_microservice_3_api_gateway.model.Role;
import com.cg.spring_boot_microservice_3_api_gateway.model.User;
import com.cg.spring_boot_microservice_3_api_gateway.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveUser() {
        User user = new User();
        user.setPassword("rawPass");

        when(passwordEncoder.encode("rawPass")).thenReturn("encodedPass");
        when(userRepository.save(any(User.class))).thenAnswer(inv -> inv.getArgument(0));

        User result = userService.saveUser(user);
        assertEquals("encodedPass", result.getPassword());
        assertEquals(Role.USER, result.getRole());
        assertNotNull(result.getCreateTime());
    }

    @Test
    public void testFindByUsername() {
        User user = new User();
        user.setUsername("john");
        when(userRepository.findByUsername("john")).thenReturn(Optional.of(user));

        Optional<User> result = userService.findByUsername("john");
        assertTrue(result.isPresent());
        assertEquals("john", result.get().getUsername());
    }

    @Test
    public void testChangeRole() {
        userService.changeRole(Role.ADMIN, "john");
        verify(userRepository).updateUserRole("john", Role.ADMIN);
    }
}
