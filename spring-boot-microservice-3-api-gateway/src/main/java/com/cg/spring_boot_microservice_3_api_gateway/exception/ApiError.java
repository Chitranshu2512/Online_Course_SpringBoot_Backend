package com.cg.spring_boot_microservice_3_api_gateway.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ApiError {
    private LocalDateTime timestamp;
    private String message;
    private String path;
    private int status;
}
