package _1_GringottsDB;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "wizard_deposits")
public class WizardDeposits {
//    id – Primary Key (number in range [1, 231-1].
//    first_name – Text field with max length of 50 symbols.
//    last_name - Text field with max length of 60 symbols. Required
//    notes – Text field with max length of 1000 symbols
//    age – Required
//    magic_wand_creator – Text field with max length of 100 symbols
//    magic_wand_size – Number in range [1, 215-1]
//    deposit_group - Text field with max length of 20 symbols
//    deposit_start_date – Date and time field
//    deposit_amount – Floating point number field
//    deposit_interest - Floating point number field
//    deposit_charge - Floating point number field
//    deposit_expiration_date – Date and time field
//    is_deposit_expired – Boolean field
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name", columnDefinition = "VARCHAR(50)")
    private String firstName;
    @Column(name = "last_name", columnDefinition = "VARCHAR(60)", nullable = false)
    private String lastName;
    @Column(name = "notes", columnDefinition = "TEXT")
    private String notes;
    @Column(name = "age", nullable = false)
    private int age;
    @Column(name = "magic_wand_creator", columnDefinition = "TEXT")
    private String magicWandCreator;
    @Column(name = "magic_wand_size", columnDefinition = "SMALLINT")
    private int magicWandSize;
    @Column(name = "deposit_group", columnDefinition = "VARCHAR(20)")
    private String depositGroup;
    @Column(name = "deposit_start_date", columnDefinition = "DATETIME")
    private LocalDateTime depositStartDate;
    @Column(name = "deposit_amount", columnDefinition = "DECIMAL(10,2)")
    private BigDecimal depositAmount;
    @Column(name = "deposit_interest", columnDefinition = "DECIMAL(10,2)")
    private BigDecimal depositInterest;
    @Column(name = "deposit_charge", columnDefinition = "DECIMAL(10,2)")
    private BigDecimal depositCharge;
    @Column(name = "deposit_expiration_date", columnDefinition = "DATETIME")
    private LocalDateTime depositExpirationDate;
    @Column(name = "is_deposit_expired", columnDefinition = "BIT")
    private boolean isDepositExpired;

    public WizardDeposits() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMagicWandCreator() {
        return magicWandCreator;
    }

    public void setMagicWandCreator(String magicWandCreator) {
        this.magicWandCreator = magicWandCreator;
    }

    public int getMagicWandSize() {
        return magicWandSize;
    }

    public void setMagicWandSize(int magicWandSize) {
        this.magicWandSize = magicWandSize;
    }

    public String getDepositGroup() {
        return depositGroup;
    }

    public void setDepositGroup(String depositGroup) {
        this.depositGroup = depositGroup;
    }

    public LocalDateTime getDepositStartDate() {
        return depositStartDate;
    }

    public void setDepositStartDate(LocalDateTime depositStartDate) {
        this.depositStartDate = depositStartDate;
    }

    public BigDecimal getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(BigDecimal depositAmount) {
        this.depositAmount = depositAmount;
    }

    public BigDecimal getDepositInterest() {
        return depositInterest;
    }

    public void setDepositInterest(BigDecimal depositInterest) {
        this.depositInterest = depositInterest;
    }

    public BigDecimal getDepositCharge() {
        return depositCharge;
    }

    public void setDepositCharge(BigDecimal depositCharge) {
        this.depositCharge = depositCharge;
    }

    public LocalDateTime getDepositExpirationDate() {
        return depositExpirationDate;
    }

    public void setDepositExpirationDate(LocalDateTime depositExpirationDate) {
        this.depositExpirationDate = depositExpirationDate;
    }

    public boolean isDepositExpired() {
        return isDepositExpired;
    }

    public void setDepositExpired(boolean depositExpired) {
        isDepositExpired = depositExpired;
    }
}