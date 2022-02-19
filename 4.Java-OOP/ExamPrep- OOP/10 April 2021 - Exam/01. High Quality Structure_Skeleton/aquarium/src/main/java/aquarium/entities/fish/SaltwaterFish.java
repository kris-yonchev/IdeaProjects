package aquarium.entities.fish;

public class SaltwaterFish extends BaseFish {

    private static int initialSize = 5;

    public SaltwaterFish(String name, String species, double price) {
        super(name, species, price);
    }

    @Override
    public void eat() {
        initialSize = this.getSize() + 2;
    }
}
