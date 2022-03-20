package com.example.demo.services;

import com.example.demo.entities.Customer;
import com.example.demo.entities.q1.CustomerRootInfoDto;
import com.example.demo.entities.q5.CustomerRootWithCarDto;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

public interface CustomerService {

    void seedDate() throws IOException, JAXBException;

    Customer getRandomCustomer();

    List<Customer> findAll();


    CustomerRootInfoDto getAllCustomers();

    CustomerRootWithCarDto getCustomerWithAtLeastOneBoughtCar();
}
