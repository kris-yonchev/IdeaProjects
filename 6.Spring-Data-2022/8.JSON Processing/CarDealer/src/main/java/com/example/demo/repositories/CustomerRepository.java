package com.example.demo.repositories;

import com.example.demo.entities.Customer;
import com.example.demo.entities.dto.q5.CustomerCarCountDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("SELECT c FROM Customer c" +
            " WHERE c.sales.size > 0")
    List<Customer> getAllBySaleListBiggerThanOne();
}
