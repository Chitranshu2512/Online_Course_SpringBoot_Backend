package com.cg.springbootmicroservice2purchase.controller;

import com.cg.springbootmicroservice2purchase.model.Purchase;
import com.cg.springbootmicroservice2purchase.service.PaymentService;
import com.cg.springbootmicroservice2purchase.service.PurchaseService;
import com.razorpay.Order;
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

    @PostMapping("/create-payment")
    public ResponseEntity<?> createPayment(@RequestParam Double amount) {
        try {
            Order order = paymentService.createOrder(amount);
            return new ResponseEntity<>(order.toString(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Payment creation failed: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/payment-success")
    public ResponseEntity<?> paymentSuccess(
            @RequestParam Long userId,
            @RequestParam Long courseId,
            @RequestParam String title,
            @RequestParam Double price,
            @RequestParam String razorpayPaymentId,
            @RequestParam String razorpayOrderId,
            @RequestParam String razorpaySignature
    ) {
        Purchase savedPurchase = purchaseService.processSuccessfulPayment(userId, courseId, title, price);
        return new ResponseEntity<>(savedPurchase, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getAllPurchasesOfUser(@PathVariable Long userId) {
        return ResponseEntity.ok(purchaseService.findAllPurchasesOfUser(userId));
    }
}
