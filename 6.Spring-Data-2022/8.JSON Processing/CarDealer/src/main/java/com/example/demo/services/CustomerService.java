package com.example.demo.services;

import com.example.demo.entities.Customer;
import com.example.demo.entities.dto.q5.CustomerCarCountDto;

import java.io.IOException;
import java.util.List;

public interface CustomerService {

    void seedDate() throws IOException;

    Customer getRandomCustomer();

    List<Customer> findAll();


    List<CustomerCarCountDto> getCustomerCars();
}
