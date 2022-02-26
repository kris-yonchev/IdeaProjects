package entities;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
public class Company {
    @Id
    private BigInteger id;
    private String name;


    public Company() {
    }


    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
