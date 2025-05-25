package com.cg.springbootmicroservice2purchase.service;

import java.util.List;

import com.cg.springbootmicroservice2purchase.model.Purchase;

public interface PurchaseService
{
    Purchase savePurchase(Purchase purchase);

    List<Purchase> findAllPurchasesOfUser(Long userId);
}
