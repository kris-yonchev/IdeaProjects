package com.example.demo.entities.q6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "sales")
@XmlAccessorType(XmlAccessType.FIELD)
public class SaleRootWithCarCustomerPriceDto {

    @XmlElement(name = "sale")
    private List<SaleWithCarCustomerPriceDto> carCustomerPriceDto;

    public SaleRootWithCarCustomerPriceDto() {
    }

    public List<SaleWithCarCustomerPriceDto> getCarCustomerPriceDto() {
        return carCustomerPriceDto;
    }

    public void setCarCustomerPriceDto(List<SaleWithCarCustomerPriceDto> carCustomerPriceDto) {
        this.carCustomerPriceDto = carCustomerPriceDto;
    }
}
