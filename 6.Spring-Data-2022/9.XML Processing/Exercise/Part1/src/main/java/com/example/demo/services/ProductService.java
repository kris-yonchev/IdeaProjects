package com.example.demo.services;

import com.example.demo.entities.product.ProductsRootInRangeDto;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.math.BigDecimal;

public interface ProductService {

    void seedData() throws IOException, JAXBException;


    ProductsRootInRangeDto findAllProductInRangeOrderByPrice(BigDecimal lower, BigDecimal higher);
}
