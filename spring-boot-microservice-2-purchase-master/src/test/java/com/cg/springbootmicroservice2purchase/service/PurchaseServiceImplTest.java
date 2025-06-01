package com.cg.springbootmicroservice2purchase.service;

import com.cg.springbootmicroservice2purchase.model.Purchase;
import com.cg.springbootmicroservice2purchase.repository.PurchaseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PurchaseServiceImplTest {

    @Mock
    private PurchaseRepository purchaseRepository;

    @InjectMocks
    private PurchaseServiceImpl purchaseService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testProcessSuccessfulPayment() {
        Purchase purchase = new Purchase();
        purchase.setUserId(1L);
        purchase.setCourseId(101L);
        purchase.setTitle("Java Basics");
        purchase.setPrice(199.0);

        Purchase savedPurchase = new Purchase();
        savedPurchase.setId(1L);
        savedPurchase.setUserId(1L);
        savedPurchase.setCourseId(101L);
        savedPurchase.setTitle("Java Basics");
        savedPurchase.setPrice(199.0);
        savedPurchase.setPurchaseTime(LocalDateTime.now());

        when(purchaseRepository.save(any(Purchase.class))).thenReturn(savedPurchase);

        Purchase result = purchaseService.processSuccessfulPayment(
                purchase.getUserId(),
                purchase.getCourseId(),
                purchase.getTitle(),
                purchase.getPrice()
        );

        assertNotNull(result.getId());
        assertEquals("Java Basics", result.getTitle());
    }

    @Test
    void testFindAllPurchasesOfUser() {
        Purchase purchase1 = new Purchase();
        purchase1.setUserId(1L);
        purchase1.setCourseId(101L);
        purchase1.setTitle("Java Basics");
        purchase1.setPrice(199.0);
        purchase1.setPurchaseTime(LocalDateTime.now());

        Purchase purchase2 = new Purchase();
        purchase2.setUserId(1L);
        purchase2.setCourseId(102L);
        purchase2.setTitle("Spring Boot");
        purchase2.setPrice(249.0);
        purchase2.setPurchaseTime(LocalDateTime.now());

        when(purchaseRepository.findAllByUserId(1L)).thenReturn(Arrays.asList(purchase1, purchase2));

        List<Purchase> result = purchaseService.findAllPurchasesOfUser(1L);

        assertEquals(2, result.size());
        assertEquals("Java Basics", result.get(0).getTitle());
        assertEquals("Spring Boot", result.get(1).getTitle());
    }
}



















//package com.cg.springbootmicroservice2purchase.service;
//
//import com.cg.springbootmicroservice2purchase.model.Purchase;
//import com.cg.springbootmicroservice2purchase.repository.PurchaseRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.time.LocalDateTime;
//import java.util.Arrays;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//public class PurchaseServiceImplTest {
//
//    @Mock
//    private PurchaseRepository purchaseRepository;
//
//    @InjectMocks
//    private PurchaseServiceImpl purchaseService;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void testProcessSuccessfulPayment() {
//        Purchase purchase = new Purchase();
//        purchase.setUserId(1L);
//        purchase.setCourseId(101L);
//        purchase.setTitle("Java Basics");
//        purchase.setPrice(199.0);
//
//        Purchase savedPurchase = new Purchase();
//        savedPurchase.setId(1L);
//        savedPurchase.setUserId(1L);
//        savedPurchase.setCourseId(101L);
//        savedPurchase.setTitle("Java Basics");
//        savedPurchase.setPrice(199.0);
//        savedPurchase.setPurchaseTime(LocalDateTime.now());
//
//        when(purchaseRepository.save(any(Purchase.class))).thenReturn(savedPurchase);
//
//        Purchase result = purchaseService.savePurchase(purchase);
//
//        assertNotNull(result.getId());
//        assertEquals("Java Basics", result.getTitle());
//    }
//
//    @Test
//    void testFindAllPurchasesOfUser() {
//        Purchase purchase1 = new Purchase();
//        purchase1.setUserId(1L);
//        purchase1.setCourseId(101L);
//        purchase1.setTitle("Java Basics");
//        purchase1.setPrice(199.0);
//        purchase1.setPurchaseTime(LocalDateTime.now());
//
//        Purchase purchase2 = new Purchase();
//        purchase2.setUserId(1L);
//        purchase2.setCourseId(102L);
//        purchase2.setTitle("Spring Boot");
//        purchase2.setPrice(249.0);
//        purchase2.setPurchaseTime(LocalDateTime.now());
//
//        when(purchaseRepository.findAllByUserId(1L)).thenReturn(Arrays.asList(purchase1, purchase2));
//
//        List<Purchase> result = purchaseService.findAllPurchasesOfUser(1L);
//
//        assertEquals(2, result.size());
//    }
//}
