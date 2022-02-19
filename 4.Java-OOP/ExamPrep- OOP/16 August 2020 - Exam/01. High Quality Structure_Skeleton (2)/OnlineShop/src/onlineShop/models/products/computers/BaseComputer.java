package onlineShop.models.products.computers;

import onlineShop.common.constants.ExceptionMessages;
import onlineShop.models.products.BaseProduct;
import onlineShop.models.products.Product;
import onlineShop.models.products.components.Component;
import onlineShop.models.products.peripherals.Peripheral;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseComputer extends BaseProduct implements Computer {

    private List<Component> components;
    private List<Peripheral> peripherals;

    protected BaseComputer(int id, String manufacturer, String model, double price, double overallPerformance) {
        super(id, manufacturer, model, price, overallPerformance);
        this.components = new ArrayList<>();
        this.peripherals = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder(super.toString());

        output.append(System.lineSeparator());
        output.append(String.format(" Components (%d):", getComponents().size()))
                .append(System.lineSeparator());
        for (Component component : components) {
            output.append("  " + component.toString())
                    .append(System.lineSeparator());
        }
        double averageOverallPerformance = peripherals.stream().mapToDouble(p -> p.getOverallPerformance()).average().orElse(0);

        output.append(String.format(" Peripherals (%d); Average Overall Performance (%.2f):", peripherals.size(), averageOverallPerformance));
        output.append(System.lineSeparator());

        for (Peripheral peripheral : peripherals) {
            output.append("  " + peripheral.toString())
                    .append(System.lineSeparator());

        }
        return output.toString().trim();
    }

    @Override
    public double getOverallPerformance() {
        double averagePerformance = components.stream().mapToDouble(Component::getOverallPerformance).average().orElse(0);
        return super.getOverallPerformance() + averagePerformance;
    }

    @Override
    public double getPrice() {
        double allComponents = components.stream().mapToDouble(Component::getPrice).sum();
        double allPeripherals = peripherals.stream().mapToDouble(Product::getPrice).sum();
        return super.getPrice() + allComponents + allPeripherals;
    }


    @Override
    public List<Component> getComponents() {
        return this.components;
    }

    @Override
    public List<Peripheral> getPeripherals() {
        return this.peripherals;
    }

    @Override
    public void addComponent(Component component) {
        if (components.stream().anyMatch(c -> c.getClass() == component.getClass())) {
            throw new IllegalArgumentException(
                    String.format(ExceptionMessages.EXISTING_COMPONENT, component.getClass().getSimpleName()
                            , this.getClass().getSimpleName()
                            , this.getId())
            );
        }
        this.components.add(component);
    }

    @Override
    public Component removeComponent(String componentType) {
        if (components.stream().noneMatch(c -> c.getClass().getSimpleName().equals(componentType))) {
            throw new IllegalArgumentException(
                    String.format(ExceptionMessages.NOT_EXISTING_COMPONENT,
                            componentType,
                            this.getClass().getSimpleName(),
                            this.getId())
            );
        }
        Component component = components.stream().filter(c -> c.getClass().getSimpleName().equals(componentType)).findFirst().get();
        this.components.remove(component);
        return component;
    }

    @Override
    public void addPeripheral(Peripheral peripheral) {
        if (peripherals.stream().anyMatch(p -> p.getClass() == peripheral.getClass())) {
            throw new IllegalArgumentException(
                    String.format(ExceptionMessages.NOT_EXISTING_PERIPHERAL,
                            peripheral.getClass().getSimpleName(),
                            this.getClass().getSimpleName(),
                            this.getId())
            );
        }
        this.peripherals.add(peripheral);
    }

    @Override
    public Peripheral removePeripheral(String peripheralType) {
        if (peripherals.stream().noneMatch(p -> p.getClass().getSimpleName().equals(peripheralType))) {
            throw new IllegalArgumentException(
                    String.format(ExceptionMessages.NOT_EXISTING_PERIPHERAL,
                            peripheralType,
                            this.getClass().getSimpleName(),
                            this.getId()));
        }
        Peripheral peripheral = peripherals.stream().filter(p -> p.getClass().getSimpleName().equals(peripheralType)).findFirst().get();
        this.peripherals.remove(peripheral);
        return peripheral;
    }
}
