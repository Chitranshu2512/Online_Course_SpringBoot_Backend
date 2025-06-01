package com.cg.springbootmicroservice2purchase.service;

import com.cg.springbootmicroservice2purchase.model.Purchase;

import java.util.List;

public interface PurchaseService {
    Purchase processSuccessfulPayment(Long userId, Long courseId, String title, Double price);

    List<Purchase> findAllPurchasesOfUser(Long userId);
}
