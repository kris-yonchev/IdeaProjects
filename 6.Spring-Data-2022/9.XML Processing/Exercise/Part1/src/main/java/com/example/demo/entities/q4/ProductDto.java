package com.example.demo.entities.q4;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "sold-products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductDto {

    @XmlAttribute(name = "count")
    private Integer count;

    @XmlElement(name = "product")
    private List<ProductInfoDto> soldProducts;

    public ProductDto() {
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<ProductInfoDto> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(List<ProductInfoDto> soldProducts) {
        this.soldProducts = soldProducts;
    }
}
