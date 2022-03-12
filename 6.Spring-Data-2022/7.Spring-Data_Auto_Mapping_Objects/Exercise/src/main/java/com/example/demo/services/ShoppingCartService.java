package com.example.demo.services;

public interface ShoppingCartService {

    String AddItem(String gameTitle);

    String removeItem(String gameTitle);

    String BuyItem();
}
