package com.example.demo.repositories;

import com.example.demo.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
    List<Sale> findAllByCustomerId(Long id);

    List<Sale> findAll();
}
