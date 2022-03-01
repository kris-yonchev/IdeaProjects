package _5_BillsPaymentSystem;

import javax.persistence.*;

@Entity
@Table(name = "billing_details")
public class BillingDetail extends BaseEntity{

    private String number;
    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private User owner;

    public BillingDetail() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
