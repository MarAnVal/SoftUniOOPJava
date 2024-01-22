package VehiclesExtension;

public class Bus extends Vehicle {
    private final double conditionerExtraConsumptionPerKm = 1.4;

    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    public double fuelConsumptionModifier(double fuelConsumption) {
        return fuelConsumption + conditionerExtraConsumptionPerKm;
    }

}
