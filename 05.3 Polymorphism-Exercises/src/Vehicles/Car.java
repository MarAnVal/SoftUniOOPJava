package Vehicles;

import java.text.DecimalFormat;

public class Car extends Vehicle {
    private final double summerExtraConsumptionPerKm = 0.9;

    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
        setFuelConsumption(fuelConsumption);
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
}
