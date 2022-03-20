package com.example.demo.services;

import com.example.demo.entities.q6.SaleRootWithCarCustomerPriceDto;

public interface SaleService {

    void seedDate();


    SaleRootWithCarCustomerPriceDto getSales();
}
