package com.example.demo.entities.seedDto.supplier;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "suppliers")
@XmlAccessorType(XmlAccessType.FIELD)
public class SupplierRootDto {

    @XmlElement(name = "supplier")
    List<SupplierImportDto> suppliers;

    public SupplierRootDto() {
    }

    public List<SupplierImportDto> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<SupplierImportDto> suppliers) {
        this.suppliers = suppliers;
    }
}
