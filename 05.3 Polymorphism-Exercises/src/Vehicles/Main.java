package Vehicles;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Vehicle> vehicles = new HashMap<>();
        String[] carData = scanner.nextLine().split("\\s+");
        Vehicle car = new Car(Double.parseDouble(carData[1]),
                Double.parseDouble(carData[2]));
        vehicles.put(carData[0], car);
        String[] truckData = scanner.nextLine().split("\\s+");
        Vehicle truck = new Truck(Double.parseDouble(truckData[1]),
                Double.parseDouble(truckData[2]));
        vehicles.put(truckData[0], truck);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split("\\s+");
            Vehicle vehicle = vehicles.get(command[1]);
            switch (command[0]) {
                case "Drive":
                    System.out.println(vehicle.drive(Double.parseDouble(command[2])));
                    break;
                case "Refuel":
                    vehicle.refuel(Double.parseDouble(command[2]));
                break;
                    default:
                    throw new IllegalArgumentException("Unknown operation");
            }
        }
        System.out.printf("%s: %.2f%n", car.getClass().getSimpleName(), car.getFuelQuantity());
        System.out.printf("%s: %.2f%n", truck.getClass().getSimpleName(), truck.getFuelQuantity());
    }
}
