package com.example.demo.entities.q6;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;

@XmlRootElement(name = "sale")
@XmlAccessorType(XmlAccessType.FIELD)
public class SaleWithCarCustomerPriceDto {

    @XmlElement(name = "car")
    private CarSaleDto car;

    @XmlElement(name = "customer-name")
    private String customerName;

    @XmlElement
    private BigDecimal discount;

    @XmlElement
    private BigDecimal price;

    @XmlElement(name = "price-with-discount")
    private BigDecimal priceWithDiscount;

    public SaleWithCarCustomerPriceDto() {
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public CarSaleDto getCar() {
        return car;
    }

    public void setCar(CarSaleDto car) {
        this.car = car;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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
