package com.example.demo.services;

import com.example.demo.entities.dto.ProductNameAndPriceDto;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    void seedData() throws IOException;

    List<ProductNameAndPriceDto> findPriceWithPriceInRange(BigDecimal lower, BigDecimal upper);

}
