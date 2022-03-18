package com.example.demo.repositories;

import com.example.demo.entities.product.Product;
import com.example.demo.entities.product.ProductInRangeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT p FROM Product p" +
            " WHERE p.buyer IS NULL AND p.price BETWEEN :lower and :upper" +
            " ORDER BY p.price ASC")
    List<Product> findAllByPriceBetween(BigDecimal lower, BigDecimal upper);

    List<Product> findAllByPriceBetweenAndBuyerIdIsNullOrderByPriceDesc(BigDecimal lower, BigDecimal higher);
}
