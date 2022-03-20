package com.example.demo.entities.q5;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerRootWithCarDto {

    @XmlElement(name = "customer")
    private List<CustomerWithCarDto> customers;

    public CustomerRootWithCarDto() {
    }

    public List<CustomerWithCarDto> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerWithCarDto> customers) {
        this.customers = customers;
    }
}
