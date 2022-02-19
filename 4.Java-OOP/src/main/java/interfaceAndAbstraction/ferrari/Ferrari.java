package interfaceAndAbstraction.ferrari;

public class Ferrari implements Car {
    private String driverName;
    private String modelName;

    public Ferrari(String driverName) {
        this.driverName = driverName;
        this.modelName = "488-Spider";
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s", this.modelName, this.brakes(), this.gas(), this.driverName);
    }

    @Override
    public String brakes() {
        return "Brakes!";
    }

    @Override
    public String gas() {
        return "brum-brum-brum-brrrrr";
    }
}
