package catHouse.entities.cat;

public class ShorthairCat extends BaseCat {
    private final static int kilograms = 7;

    public ShorthairCat(String name, String breed, double price) {
        super(name, breed, price);
        this.setKilograms(kilograms);
    }

}
