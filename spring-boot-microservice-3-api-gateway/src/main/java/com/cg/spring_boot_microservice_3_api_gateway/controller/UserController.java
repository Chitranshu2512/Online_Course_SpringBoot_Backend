package com.cg.spring_boot_microservice_3_api_gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.spring_boot_microservice_3_api_gateway.exception.UnauthorizedAccessException;
import com.cg.spring_boot_microservice_3_api_gateway.model.Role;
import com.cg.spring_boot_microservice_3_api_gateway.security.UserPrincipal;
import com.cg.spring_boot_microservice_3_api_gateway.service.UserService;

@RestController
@RequestMapping("api/user") //pre-path
public class UserController
{
    @Autowired
    private UserService userService;

    @PutMapping("change/{role}")    //api/user/change/{role}
    public ResponseEntity<?> changeRole(@AuthenticationPrincipal UserPrincipal userPrincipal, @PathVariable Role role)
    {
//        userService.changeRole(role, userPrincipal.getUsername());
//
//        return ResponseEntity.ok(true);
    	
    	try {
            userService.changeRole(role, userPrincipal.getUsername());
            return ResponseEntity.ok(true);
        } catch (Exception ex) {
            throw new UnauthorizedAccessException("You are not authorized to change the role.");
        }
    }
}
