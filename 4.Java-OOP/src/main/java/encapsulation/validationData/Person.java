package encapsulation.validationData;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setSalary(salary);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary < 460.0) {
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        checkName(firstName, "First");
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        checkName(lastName, "Last");
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }
        this.age = age;
    }

    public void increaseSalary(double bonus) {
        if (this.age < 30) {
            bonus /= 2;
        }
        setSalary(this.salary + (this.salary * bonus / 100));
    }

    private void checkName(String name, String firstOrLast) {
        if (name.length() < 3) {
            throw new IllegalArgumentException(firstOrLast + " name cannot be less than 3 symbols");
        }

    }

    @Override
    public String toString() {
        return String.format("%s %s is %d years old.", this.getFirstName(), this.getLastName(), this.getAge());
    }
}
