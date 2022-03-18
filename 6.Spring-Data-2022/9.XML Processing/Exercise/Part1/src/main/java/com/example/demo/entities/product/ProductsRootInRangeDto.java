package com.example.demo.entities.product;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductsRootInRangeDto {

    @XmlElement(name = "product")
    private List<ProductInRangeDto> products;

    public ProductsRootInRangeDto() {
    }

    public List<ProductInRangeDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductInRangeDto> products) {
        this.products = products;
    }
}
