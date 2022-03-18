package com.example.demo.entities.user;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserWithSoldProductsDto {

    @XmlElement(name = "user")
    private List<UserWithProductDto> users;

    public UserWithSoldProductsDto() {
    }

    public List<UserWithProductDto> getUserWithProductDtos() {
        return users;
    }

    public void setUserWithProductDtos(List<UserWithProductDto> userWithProductDtos) {
        this.users = userWithProductDtos;
    }
}
