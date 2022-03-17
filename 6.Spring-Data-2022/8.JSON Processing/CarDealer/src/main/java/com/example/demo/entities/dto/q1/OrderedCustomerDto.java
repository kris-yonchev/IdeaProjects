package com.example.demo.entities.dto.q1;

import com.google.gson.annotations.Expose;

import java.util.List;

public class OrderedCustomerDto {

    @Expose
    private long id;

    @Expose
    private String name;

    @Expose
    private String birthDate;

    @Expose
    private List<SaleCustomerDto> sales;

    public OrderedCustomerDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public List<SaleCustomerDto> getSales() {
        return sales;
    }

    public void setSales(List<SaleCustomerDto> sales) {
        this.sales = sales;
    }
}
