package onlineShop.core;

import onlineShop.common.constants.ExceptionMessages;
import onlineShop.common.constants.OutputMessages;
import onlineShop.core.interfaces.Controller;
import onlineShop.models.products.components.*;
import onlineShop.models.products.computers.Computer;
import onlineShop.models.products.computers.DesktopComputer;
import onlineShop.models.products.computers.Laptop;
import onlineShop.models.products.peripherals.*;

import java.util.*;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

    private Collection<Computer> computers;
    private Collection<Component> components;
    private Collection<Peripheral> peripherals;

    public ControllerImpl() {
        computers = new ArrayList<>();
        components = new ArrayList<>();
        peripherals = new ArrayList<>();
    }


    @Override
    public String addComputer(String computerType, int id, String manufacturer, String model, double price) {
        Computer computer;
        switch (computerType) {
            case "DesktopComputer":
                computer = new DesktopComputer(id, manufacturer, model, price);
                break;
            case "Laptop":
                computer = new Laptop(id, manufacturer, model, price);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_COMPUTER_TYPE);
        }

        if (computers.stream().anyMatch(c -> c.getId() == id)) {
            throw new IllegalArgumentException(ExceptionMessages.EXISTING_COMPUTER_ID);
        }

        computers.add(computer);
        return String.format(OutputMessages.ADDED_COMPUTER, id);
    }

    @Override
    public String addPeripheral(int computerId, int id, String peripheralType, String manufacturer, String model, double price, double overallPerformance, String connectionType) {
        if (idDoesNotExist(computerId)) {
            throw new IllegalArgumentException(ExceptionMessages.NOT_EXISTING_COMPUTER_ID);
        }
        Peripheral peripheral;
        switch (peripheralType) {
            case "Headset":
                peripheral = new Headset(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Keyboard":
                peripheral = new Keyboard(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Monitor":
                peripheral = new Monitor(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Mouse":
                peripheral = new Mouse(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_PERIPHERAL_TYPE);
        }

        if (peripherals.stream().anyMatch(p -> p.getId() == id)) {
            throw new IllegalArgumentException(ExceptionMessages.EXISTING_PERIPHERAL_ID);
        }

        peripherals.add(peripheral);
        for (Computer computer : computers) {
            if (computer.getId() == computerId) {
                computer.getPeripherals().add(peripheral);
            }
        }
        return String.format(OutputMessages.ADDED_PERIPHERAL, peripheralType, id, computerId);

    }

    @Override
    public String removePeripheral(String peripheralType, int computerId) {
        if (idDoesNotExist(computerId)) {
            throw new IllegalArgumentException(ExceptionMessages.NOT_EXISTING_COMPUTER_ID);
        }
        Peripheral peripheral = null;

        for (Computer computer : computers) {
            if (computer.getId() == computerId) {
                peripheral = computer.removePeripheral(peripheralType);
                this.peripherals.remove(peripheral);
            }
        }
        return String.format(OutputMessages.REMOVED_PERIPHERAL, peripheralType, peripheral.getId());
    }

    @Override
    public String addComponent(int computerId, int id, String componentType, String manufacturer, String model, double price, double overallPerformance, int generation) {

        if (idDoesNotExist(computerId)) {
            throw new IllegalArgumentException(ExceptionMessages.NOT_EXISTING_COMPUTER_ID);
        }

        Component component;
        switch (componentType) {
            case "CentralProcessingUnit":
                component = new CentralProcessingUnit(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "Motherboard":
                component = new Motherboard(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "PowerSupply":
                component = new PowerSupply(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "RandomAccessMemory":
                component = new RandomAccessMemory(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "SolidStateDrive":
                component = new SolidStateDrive(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "VideoCard":
                component = new VideoCard(id, manufacturer, model, price, overallPerformance, generation);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_COMPONENT_TYPE);
        }
        if (components.stream().anyMatch(c -> c.getId() == id)) {
            throw new IllegalArgumentException(ExceptionMessages.EXISTING_COMPONENT_ID);
        }

        components.add(component);
        for (Computer computer : computers) {
            if (computer.getId() == computerId) {
                computer.getComponents().add(component);
            }
        }
        return String.format(OutputMessages.ADDED_COMPONENT, componentType, id, computerId);
    }

    @Override
    public String removeComponent(String componentType, int computerId) {
        if (idDoesNotExist(computerId)) {
            throw new IllegalArgumentException(ExceptionMessages.NOT_EXISTING_COMPUTER_ID);
        }
        Component component = null;
        for (Computer computer : computers) {
            if (computer.getId() == computerId) {
                component = computer.removeComponent(componentType);
                components.remove(component);
            }
        }


        return String.format(OutputMessages.REMOVED_COMPONENT, componentType, component.getId());
    }

    @Override
    public String buyComputer(int id) {
        if (idDoesNotExist(id)) {
            throw new IllegalArgumentException(ExceptionMessages.NOT_EXISTING_COMPUTER_ID);
        }
        Computer computer = computers.stream().filter(c -> c.getId() == id).findFirst().get();
        computers.remove(computer);
        return computer.toString();
    }

    @Override
    public String BuyBestComputer(double budget) {
        Computer computer = computers
                .stream().filter(c -> c.getPrice() <= budget)
                .max(Comparator.comparing(computer1 -> computer1.getOverallPerformance()))
                .orElse(null);

        if (computer == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.CAN_NOT_BUY_COMPUTER, budget));
        }
        computers.remove(computer);
        return computer.toString();
    }

    @Override
    public String getComputerData(int id) {
        if (idDoesNotExist(id)) {
            throw new IllegalArgumentException(ExceptionMessages.NOT_EXISTING_COMPUTER_ID);
        }

        Computer computer = computers.stream().filter(c -> c.getId() == id).findFirst().get();
        return computer.toString();
    }

    private boolean idDoesNotExist(int id) {
        return computers.stream().noneMatch(c -> c.getId() == id);
    }
}
