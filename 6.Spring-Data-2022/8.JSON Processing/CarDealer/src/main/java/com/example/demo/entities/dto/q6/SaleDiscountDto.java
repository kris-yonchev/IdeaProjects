package com.example.demo.entities.dto.q6;

import com.example.demo.entities.dto.q4.CarInfoDto;
import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class SaleDiscountDto {

    @Expose
    private CarInfoDto car;

    @Expose
    private String customerName;

    @Expose
    private BigDecimal discount;

    @Expose
    private BigDecimal price;

    @Expose
    private BigDecimal priceWithDiscount;

    public SaleDiscountDto() {
    }

    public CarInfoDto getCar() {
        return car;
    }

    public void setCar(CarInfoDto car) {
        this.car = car;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPriceWithDiscount() {
        return priceWithDiscount;
    }

    public void setPriceWithDiscount(BigDecimal priceWithDiscount) {
        this.priceWithDiscount = priceWithDiscount;
    }
}
