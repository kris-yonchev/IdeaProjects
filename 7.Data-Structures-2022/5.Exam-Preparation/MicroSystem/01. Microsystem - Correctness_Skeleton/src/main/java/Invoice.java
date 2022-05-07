import java.time.LocalDate;
import java.util.Objects;

public class Invoice {

    private String number;
    private String companyName;
    private double subtotal;
    private Department department;
    private LocalDate issueDate;
    private LocalDate dueDate;

    public Invoice(String number, String companyName, double subtotal, Department department, LocalDate issueDate, LocalDate dueDate) {
        this.number = number;
        this.companyName = companyName;
        this.subtotal = subtotal;
        this.department = department;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return Double.compare(invoice.subtotal, subtotal) == 0 &&
                Objects.equals(number, invoice.number) &&
                Objects.equals(companyName, invoice.companyName) &&
                department == invoice.department &&
                Objects.equals(issueDate, invoice.issueDate) &&
                Objects.equals(dueDate, invoice.dueDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, companyName, subtotal, department, issueDate, dueDate);
    }
}
