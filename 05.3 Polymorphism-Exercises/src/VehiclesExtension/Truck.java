package VehiclesExtension;

public class Truck extends Vehicle {
    private final double conditionerExtraConsumptionPerKm = 1.6;
    private final double refuelLitersCoefficient = 0.95;

    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    public double fuelConsumptionModifier(double fuelConsumption) {
        return fuelConsumption + conditionerExtraConsumptionPerKm;
    }

    @Override
    public double fuelRefuelModifier(double liters) {
        return liters * refuelLitersCoefficient;
    }
}
