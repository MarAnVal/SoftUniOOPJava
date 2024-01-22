package VehiclesExtension;

public class Car extends Vehicle {
    private final double conditionerExtraConsumptionPerKm = 0.9;

    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    public double fuelConsumptionModifier(double fuelConsumption) {
        return fuelConsumption + conditionerExtraConsumptionPerKm;
    }
}
