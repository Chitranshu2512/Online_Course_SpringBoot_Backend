package com.cg.spring_boot_microservice_3_api_gateway.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentSuccessRequest {
    private Long userId;
    private Long courseId;
    private String title;
    private Double price;
    private String razorpayPaymentId;
    private String razorpayOrderId;
    private String razorpaySignature;
}
