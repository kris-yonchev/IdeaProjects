package com.example.demo.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "sales")
public class Sale extends BaseEntity {

    @Column(name = "discount")
    private BigDecimal discountPercentage;

    @OneToOne
    private Car car;

    @ManyToOne
    private Customer customer;

    public Sale() {
    }

    public Sale(BigDecimal discountPercentage, Car car, Customer customer) {
        this.discountPercentage = discountPercentage;
        this.car = car;
        this.customer = customer;
    }

    public BigDecimal getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(BigDecimal discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

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



}
