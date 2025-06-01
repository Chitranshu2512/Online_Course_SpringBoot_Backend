package com.cg.spring_boot_microservice_3_api_gateway.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import com.cg.spring_boot_microservice_3_api_gateway.dto.PaymentSuccessRequest;
import com.cg.spring_boot_microservice_3_api_gateway.request.PurchaseServiceRequest;
import com.cg.spring_boot_microservice_3_api_gateway.security.UserPrincipal;
import com.cg.spring_boot_microservice_3_api_gateway.service.PurchaseGatewayService;


@RestController
@RequestMapping("gateway/purchase")//pre-path
public class PurchaseController
{
    @Autowired
    private PurchaseServiceRequest purchaseServiceRequest;
    
    @Autowired
    private PurchaseGatewayService purchaseGatewayService;

    @PostMapping("/create-payment")
    public ResponseEntity<Map<String, String>> createPayment(@RequestParam Double amount) {
        Map<String, String> response = purchaseServiceRequest.createPayment(amount);
        return ResponseEntity.ok(response);
    }



    @PostMapping(value = "/payment-success", consumes = "multipart/form-data")
    public ResponseEntity<?> confirmPaymentSuccess(@ModelAttribute PaymentSuccessRequest request) {
        return new ResponseEntity<>(purchaseServiceRequest.confirmPaymentSuccess(request), HttpStatus.OK);
    }




    @GetMapping//gateway/purchase
    public ResponseEntity<?> getAllPurchasesOfAuthorizedUser(@AuthenticationPrincipal UserPrincipal userPrincipal)
    {
        return ResponseEntity.ok(purchaseServiceRequest.getAllPurchasesOfUser(userPrincipal.getId()));
    }
}
