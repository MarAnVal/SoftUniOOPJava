package Vehicles;

import java.text.DecimalFormat;

public class Truck extends Vehicle {
    private final double summerExtraConsumptionPerKm = 1.6;
    private final double refuelLitersCoefficient = 0.95;

    public Truck(double fuelQuantity, double consumption) {
        super(fuelQuantity, consumption);
    }

    @Override
    public String drive(double km) {
        double summerFuelConsumption = this.getFuelConsumption() + summerExtraConsumptionPerKm;
        if (this.getFuelQuantity() < km * summerFuelConsumption) {
            return String.format("%s needs refueling", this.getClass().getSimpleName());
        } else {
            this.setFuelQuantity(this.getFuelQuantity() - km * summerFuelConsumption);
            DecimalFormat df = new DecimalFormat("0.##");
            return String.format("%s travelled %s km", this.getClass().getSimpleName(),
                    df.format(km));
        }
    }

    @Override
    public void refuel(double liters) {
        super.refuel(liters * refuelLitersCoefficient);
    }
}
