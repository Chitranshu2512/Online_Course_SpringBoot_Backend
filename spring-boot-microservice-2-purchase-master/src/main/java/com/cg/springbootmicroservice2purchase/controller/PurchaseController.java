package com.cg.springbootmicroservice2purchase.controller;

import com.cg.springbootmicroservice2purchase.dto.PaymentSuccessRequest;
import com.cg.springbootmicroservice2purchase.model.Purchase;
import com.cg.springbootmicroservice2purchase.service.PaymentService;
import com.cg.springbootmicroservice2purchase.service.PurchaseService;
import com.razorpay.Order;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private PaymentService paymentService;

    @PostMapping(value = "/create-payment", produces = "application/json")
    public ResponseEntity<Map<String, String>> createPayment(@RequestParam Double amount) {
        try {
            Order order = paymentService.createOrder(amount);
            Map<String, String> response = new HashMap<>();
            response.put("orderId", order.get("id"));
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "Payment creation failed: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }

    
    @PostMapping(value = "/payment-success", consumes = "multipart/form-data")
    public ResponseEntity<?> paymentSuccess(@ModelAttribute PaymentSuccessRequest request) {
        Purchase savedPurchase = purchaseService.processSuccessfulPayment(
            request.getUserId(), request.getCourseId(), request.getTitle(), request.getPrice());
        return new ResponseEntity<>(savedPurchase, HttpStatus.CREATED);
    }


    @GetMapping("/{userId}")
    public ResponseEntity<?> getAllPurchasesOfUser(@PathVariable Long userId) {
        return ResponseEntity.ok(purchaseService.findAllPurchasesOfUser(userId));
    }
}
