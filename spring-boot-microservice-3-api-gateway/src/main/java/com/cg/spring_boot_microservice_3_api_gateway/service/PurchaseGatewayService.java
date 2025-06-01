package com.cg.spring_boot_microservice_3_api_gateway.service;

import com.cg.spring_boot_microservice_3_api_gateway.request.PurchaseServiceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PurchaseGatewayService {

    @Autowired
    private PurchaseServiceRequest purchaseServiceRequest;

    public Map<String, String> createPayment(Double amount) {
        Object response = purchaseServiceRequest.createPayment(amount);

        String raw = response.toString();  // Will be something like {id=order_xyz, entity=order, ...}
        String orderId = "unknown";
        try {
            int idIndex = raw.indexOf("id=");
            if (idIndex != -1) {
                int end = raw.indexOf(",", idIndex);
                if (end == -1) end = raw.length();
                orderId = raw.substring(idIndex + 3, end).trim();
            }
        } catch (Exception e) {
            orderId = "parse_error";
        }

        Map<String, String> map = new HashMap<>();
        map.put("orderId", orderId);
        return map;
    }
}
