package com.cg.springbootmicroservice2purchase.controller;

import com.cg.springbootmicroservice2purchase.model.Purchase;
import com.cg.springbootmicroservice2purchase.service.PaymentService;
import com.cg.springbootmicroservice2purchase.service.PurchaseService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.razorpay.Order;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalDateTime;
import java.util.Arrays;


@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest(PurchaseController.class)
public class PurchaseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PurchaseService purchaseService;

    @MockBean
    private PaymentService paymentService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCreatePayment() throws Exception {
        JSONObject json = new JSONObject();
        json.put("id", "order_test_id");

        Order mockOrder = Mockito.mock(Order.class);
        when(mockOrder.toString()).thenReturn(json.toString());
        when(paymentService.createOrder(anyDouble())).thenReturn(mockOrder);

        mockMvc.perform(post("/api/purchase/create-payment")
                        .param("amount", "500"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("order_test_id")));
    }

    @Test
    void testPaymentSuccess() throws Exception {
        Purchase purchase = new Purchase();
        purchase.setId(1L);
        purchase.setUserId(1L);
        purchase.setCourseId(101L);
        purchase.setTitle("Java Basics");
        purchase.setPrice(199.0);
        purchase.setPurchaseTime(LocalDateTime.now());

        when(purchaseService.processSuccessfulPayment(anyLong(), anyLong(), anyString(), anyDouble()))
                .thenReturn(purchase);

        mockMvc.perform(post("/api/purchase/payment-success")
                        .param("userId", "1")
                        .param("courseId", "101")
                        .param("title", "Java Basics")
                        .param("price", "199.0")
                        .param("razorpayPaymentId", "pay_xyz")
                        .param("razorpayOrderId", "order_xyz")
                        .param("razorpaySignature", "sig_xyz"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.title", is("Java Basics")));
    }

    @Test
    void testGetAllPurchasesOfUser() throws Exception {
        Purchase p1 = new Purchase();
        p1.setId(1L);
        p1.setUserId(1L);
        p1.setCourseId(101L);
        p1.setTitle("Java Basics");
        p1.setPrice(199.0);
        p1.setPurchaseTime(LocalDateTime.now());

        Purchase p2 = new Purchase();
        p2.setId(2L);
        p2.setUserId(1L);
        p2.setCourseId(102L);
        p2.setTitle("Spring Boot");
        p2.setPrice(249.0);
        p2.setPurchaseTime(LocalDateTime.now());

        when(purchaseService.findAllPurchasesOfUser(1L)).thenReturn(Arrays.asList(p1, p2));

        mockMvc.perform(get("/api/purchase/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(2)));
    }
}



























//package com.cg.springbootmicroservice2purchase.controller;
//
//import com.cg.springbootmicroservice2purchase.model.Purchase;
//import com.cg.springbootmicroservice2purchase.service.PurchaseService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.time.LocalDateTime;
//import java.util.Arrays;
//
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//import static org.hamcrest.Matchers.*;
//
//@WebMvcTest(PurchaseController.class)
//@AutoConfigureMockMvc(addFilters = false)
//public class PurchaseControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private PurchaseService purchaseService;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Test
//    void testSavePurchase() throws Exception {
//        Purchase purchase = new Purchase();
//        purchase.setUserId(1L);
//        purchase.setCourseId(101L);
//        purchase.setTitle("Java Basics");
//        purchase.setPrice(199.0);
//
//        Purchase saved = new Purchase();
//        saved.setId(1L);
//        saved.setUserId(1L);
//        saved.setCourseId(101L);
//        saved.setTitle("Java Basics");
//        saved.setPrice(199.0);
//        saved.setPurchaseTime(LocalDateTime.now());
//
//        when(purchaseService.savePurchase(any())).thenReturn(saved);
//
//        mockMvc.perform(post("/api/purchase")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(purchase)))
//                .andExpect(status().isCreated())
//                .andExpect(jsonPath("$.id", is(1)))
//                .andExpect(jsonPath("$.title", is("Java Basics")));
//    }
//
//    @Test
//    void testGetAllPurchasesOfUser() throws Exception {
//        Purchase p1 = new Purchase();
//        p1.setUserId(1L);
//        p1.setCourseId(101L);
//        p1.setTitle("Java Basics");
//        p1.setPrice(199.0);
//        p1.setPurchaseTime(LocalDateTime.now());
//
//        Purchase p2 = new Purchase();
//        p2.setUserId(1L);
//        p2.setCourseId(102L);
//        p2.setTitle("Spring Boot");
//        p2.setPrice(249.0);
//        p2.setPurchaseTime(LocalDateTime.now());
//
//        when(purchaseService.findAllPurchasesOfUser(1L)).thenReturn(Arrays.asList(p1, p2));
//
//        mockMvc.perform(get("/api/purchase/1"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.size()", is(2)));
//    }
//}
