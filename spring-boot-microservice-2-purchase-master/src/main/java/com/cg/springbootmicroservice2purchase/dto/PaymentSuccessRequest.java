package com.cg.springbootmicroservice2purchase.dto;

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
