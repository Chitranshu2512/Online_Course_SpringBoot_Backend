package com.cg.springbootmicroservice2purchase.service;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private RazorpayClient razorpayClient;

    public Order createOrder(Double amount) throws Exception {
        JSONObject options = new JSONObject();
        options.put("amount", amount.intValue() * 100); // Razorpay uses paise
        options.put("currency", "INR");
        options.put("receipt", "txn_" + System.currentTimeMillis());

        return razorpayClient.orders.create(options);
    }
}
