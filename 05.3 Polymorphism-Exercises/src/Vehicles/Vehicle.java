package Vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {
    //liters
    private double fuelQuantity;
    //liter per kilometer
    private double fuelConsumption;

    protected Vehicle(double fuelQuantity, double fuelConsumption) {
        setFuelQuantity(fuelQuantity);
        setFuelConsumption(fuelConsumption);
    }

    protected double getFuelQuantity() {
        return fuelQuantity;
    }

    protected double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public String drive(double km){
       if (fuelQuantity < km * fuelConsumption) {
           return String.format("%s needs refueling", this.getClass().getSimpleName());
       } else {
          fuelQuantity -=km*fuelConsumption;
          DecimalFormat df = new DecimalFormat("0.##");
          return String.format("%s travelled %s km", this.getClass().getSimpleName(),
                  df.format(km));
       }
    }
    public void refuel(double liters){
        this.fuelQuantity += liters;
    }

}
