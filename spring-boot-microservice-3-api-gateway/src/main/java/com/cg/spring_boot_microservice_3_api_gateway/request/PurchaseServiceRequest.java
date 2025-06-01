package com.cg.spring_boot_microservice_3_api_gateway.request;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.cg.spring_boot_microservice_3_api_gateway.dto.PaymentSuccessRequest;

import java.util.List;
import java.util.Map;

@FeignClient(
        value = "purchase-service", // microservice name
        path = "api/purchase",      // base path of purchase service
        configuration = FeignConfiguration.class
)
public interface PurchaseServiceRequest {

    @PostMapping                     // POST /api/purchase
    Object savePurchase(@RequestBody Object requestBody);

    @GetMapping("{userId}")          // GET /api/purchase/{userId}
    List<Object> getAllPurchasesOfUser(@PathVariable("userId") Long userId);

    
    @PostMapping("/create-payment")
    Map<String, String> createPayment(@RequestParam("amount") Double amount);

   
    @PostMapping(value = "/payment-success", consumes = "multipart/form-data")
    Object confirmPaymentSuccess(@ModelAttribute PaymentSuccessRequest formData);

}
