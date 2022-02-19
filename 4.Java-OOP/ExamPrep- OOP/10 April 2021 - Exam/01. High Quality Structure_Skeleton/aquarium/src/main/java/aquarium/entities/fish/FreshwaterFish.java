package aquarium.entities.fish;

public class FreshwaterFish extends BaseFish {

    private static int initialSize = 5;

    public FreshwaterFish(String name, String species, double price) {
        super(name, species, price);
    }

    @Override
    public void eat() {
        initialSize = this.getSize() + 3;
    }
}
