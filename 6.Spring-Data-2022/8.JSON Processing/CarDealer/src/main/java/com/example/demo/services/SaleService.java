package com.example.demo.services;

import com.example.demo.entities.dto.q1.SaleCustomerDto;
import com.example.demo.entities.dto.q6.SaleDiscountDto;

import java.util.List;

public interface SaleService {

    void seedDate();


    List<SaleCustomerDto> getSaleByUser(Long id);

    List<SaleDiscountDto> getAllSales();
}
