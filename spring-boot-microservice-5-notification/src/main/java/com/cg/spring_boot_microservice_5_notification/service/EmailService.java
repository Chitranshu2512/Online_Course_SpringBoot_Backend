package com.cg.spring_boot_microservice_5_notification.service;

import com.cg.spring_boot_microservice_5_notification.dto.EmailRequest;

public interface EmailService {
    void sendEmail(EmailRequest request);
}
