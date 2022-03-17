package com.example.demo.entities.dto;

import com.example.demo.entities.Car;
import com.example.demo.entities.Customer;
import com.google.gson.annotations.Expose;

public class SaleInputDto {

    @Expose
    private Car car;

    @Expose
    private Customer customer;

    @Expose
    private Integer discountPercentage;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Integer getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(Integer discountPercentage) {
        this.discountPercentage = discountPercentage;
    }
}
