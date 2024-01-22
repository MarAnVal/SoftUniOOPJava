package VehiclesExtension;

import java.text.DecimalFormat;

public abstract class Vehicle {
    //liters
    private double fuelQuantity;
    //liter per kilometer
    private double fuelConsumption;
    private final double tankCapacity;

    public Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
    }

    public double getFuelQuantity() {
        return this.fuelQuantity;
    }

    private void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity > this.tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        this.fuelQuantity = fuelQuantity;
    }

    private String driveWithExtraConsumption(double km, boolean withExtraConsumption) {
        double realConsumption;
        if (withExtraConsumption) {
            realConsumption = this.fuelConsumptionModifier(this.fuelConsumption);
        } else {
            realConsumption = this.fuelConsumption;
        }
        double neededFuel = km * realConsumption;
        if (this.getFuelQuantity() < neededFuel) {
            return String.format("%s needs refueling", this.getClass().getSimpleName());
        } else {
            setFuelQuantity(this.fuelQuantity - neededFuel);
            DecimalFormat df = new DecimalFormat("0.##");
            return String.format("%s travelled %s km", this.getClass().getSimpleName(),
                    df.format(km));
        }
    }

    public String driveEmpty(double km) {
        return driveWithExtraConsumption(km, false);
    }

    public String drive(double km) {
        return driveWithExtraConsumption(km, true);
    }

    public void refuel(double liters) {
        if (liters <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        setFuelQuantity(this.getFuelQuantity() + fuelRefuelModifier(liters));
    }

    public double fuelConsumptionModifier(double fuelConsumption) {
        return fuelConsumption;
    }

    public double fuelRefuelModifier(double liters) {
        return liters;
    }
}
