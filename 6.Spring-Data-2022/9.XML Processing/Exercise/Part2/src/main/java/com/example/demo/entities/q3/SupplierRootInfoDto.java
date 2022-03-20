package com.example.demo.entities.q3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "supplier")
@XmlAccessorType(XmlAccessType.FIELD)
public class SupplierRootInfoDto {

    @XmlElement(name = "supplier")
    List<SupplierInfoDto> suppliers;

    public SupplierRootInfoDto() {
    }

    public List<SupplierInfoDto> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<SupplierInfoDto> suppliers) {
        this.suppliers = suppliers;
    }
}
