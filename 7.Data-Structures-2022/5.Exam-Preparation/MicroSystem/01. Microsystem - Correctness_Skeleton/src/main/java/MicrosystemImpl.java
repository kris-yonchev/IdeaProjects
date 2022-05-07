import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MicrosystemImpl implements Microsystem {

    private Map<Integer, Computer> computersByNumber;

    public MicrosystemImpl() {
        this.computersByNumber = new HashMap<>();
    }

    @Override
    public void createComputer(Computer computer) {
        if (computersByNumber.containsKey(computer.getNumber())) {
            throw new IllegalArgumentException();
        }

        computersByNumber.putIfAbsent(computer.getNumber(), computer);
    }

    @Override
    public boolean contains(int number) {
        return computersByNumber.containsKey(number);
    }

    @Override
    public int count() {
        return computersByNumber.size();
    }

    @Override
    public Computer getComputer(int number) {
        if (!computersByNumber.containsKey(number)) {
            throw new IllegalArgumentException();
        }

        return computersByNumber.get(number);
    }

    @Override
    public void remove(int number) {
        if (!computersByNumber.containsKey(number)) {
            throw new IllegalArgumentException();
        }
        computersByNumber.remove(number);
    }

    @Override
    public void removeWithBrand(Brand brand) {
        boolean isRemoved = computersByNumber.values().removeIf(c -> c.getBrand().equals(brand));

        if (!isRemoved) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void upgradeRam(int ram, int number) {
        if (!computersByNumber.containsKey(number)) {
            throw new IllegalArgumentException();
        }
        Computer toUpgrade = computersByNumber.get(number);
        if (ram > toUpgrade.getRAM()) {
            toUpgrade.setRAM(ram);
        }
    }

    @Override
    public Iterable<Computer> getAllFromBrand(Brand brand) {
        return computersByNumber
                .values()
                .stream()
                .filter(c -> c.getBrand().equals(brand))
                .sorted(Comparator.comparingDouble(Computer::getPrice).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Computer> getAllWithScreenSize(double screenSize) {
        return computersByNumber
                .values()
                .stream()
                .filter(c -> c.getScreenSize() == screenSize)
                .sorted(Comparator.comparingInt(Computer::getNumber).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Computer> getAllWithColor(String color) {
        return computersByNumber
                .values()
                .stream()
                .filter(c -> c.getColor().equals(color))
                .sorted(Comparator.comparingDouble(Computer::getPrice).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Computer> getInRangePrice(double minPrice, double maxPrice) {
        return computersByNumber
                .values()
                .stream()
                .filter(c -> c.getPrice() <= maxPrice && c.getPrice() >= minPrice)
                .sorted(Comparator.comparingDouble(Computer::getPrice).reversed())
                .collect(Collectors.toList());
    }
}
