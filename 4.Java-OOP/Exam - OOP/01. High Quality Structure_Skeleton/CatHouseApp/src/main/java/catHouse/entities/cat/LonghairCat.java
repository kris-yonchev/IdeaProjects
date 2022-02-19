package catHouse.entities.cat;

public class LonghairCat extends BaseCat {
    public static final int kilograms = 9;
    public static final int kilogramsBonus = 3;

    public LonghairCat(String name, String breed, double price) {
        super(name, breed, price);
        this.setKilograms(kilograms);
    }

    @Override
    public void eating() {
        this.setKilograms(this.getKilograms() + kilogramsBonus);
    }


}
