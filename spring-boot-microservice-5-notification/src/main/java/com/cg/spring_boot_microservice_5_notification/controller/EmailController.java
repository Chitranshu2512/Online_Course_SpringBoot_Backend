package com.cg.spring_boot_microservice_5_notification.controller;

import com.cg.spring_boot_microservice_5_notification.service.UnsafeEmailServiceImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notification")
public class EmailController {

    private final UnsafeEmailServiceImpl emailService;

    public EmailController(UnsafeEmailServiceImpl emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send-email")
    public ResponseEntity<Map<String, String>> sendEmail(@RequestParam String to,
                                                         @RequestParam String subject,
                                                         @RequestParam String body) {
        emailService.sendEmail(to, subject, body);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Email sent successfully");
        return ResponseEntity.ok(response);
    }
}


//package com.cg.spring_boot_microservice_5_notification.controller;
//
//import com.cg.spring_boot_microservice_5_notification.dto.EmailRequest;
//import com.cg.spring_boot_microservice_5_notification.service.EmailService;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/notification")
//@RequiredArgsConstructor
//public class EmailController {
//
//    private final EmailService emailService;
//
//    @PostMapping("/send-email")
//    public ResponseEntity<Map<String, String>> sendEmail(@RequestBody EmailRequest request) {
//        emailService.sendEmail(request);
//
//        Map<String, String> response = new HashMap<>();
//        response.put("message", "Email sent successfully");
//        return ResponseEntity.ok(response);
//    }
//}
