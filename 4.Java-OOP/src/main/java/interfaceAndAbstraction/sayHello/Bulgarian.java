package interfaceAndAbstraction.sayHello;

public class Bulgarian extends BasePerson{
    private String name;

    public Bulgarian(String name) {
        super(name);
    }

    public String sayHello() {
        return "Здравей";
    }
}
