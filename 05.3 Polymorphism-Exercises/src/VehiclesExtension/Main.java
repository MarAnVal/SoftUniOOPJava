package VehiclesExtension;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Vehicle> vehicles = getVehicleData(scanner);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split("\\s+");
            Vehicle vehicle = vehicles.get(command[1]);
            try {
                switch (command[0]) {
                    case "Drive":
                        System.out.println(vehicle.drive(Double.parseDouble(command[2])));
                        break;
                    case "Refuel":
                        vehicle.refuel(Double.parseDouble(command[2]));
                        break;
                    case "DriveEmpty":
                        System.out.println(vehicle.driveEmpty(Double.parseDouble(command[2])));
                        break;
                }
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
       printVehicle(vehicles);
    }

    private static void printVehicle(Map<String, Vehicle> vehicles) {
        for (Map.Entry<String, Vehicle> entry : vehicles.entrySet()) {
            System.out.printf("%s: %.2f%n", entry.getValue().getClass().getSimpleName(), entry.getValue().getFuelQuantity());
        }
    }

    private static Map<String, Vehicle> getVehicleData(Scanner scanner) {
        Map<String, Vehicle> vehicles = new LinkedHashMap<>();

        String[] carData = scanner.nextLine().split("\\s+");
        Vehicle car = new Car(Double.parseDouble(carData[1]),
                Double.parseDouble(carData[2]),
                Double.parseDouble(carData[3]));
        vehicles.put(carData[0], car);

        String[] truckData = scanner.nextLine().split("\\s+");
        Vehicle truck = new Truck(Double.parseDouble(truckData[1]),
                Double.parseDouble(truckData[2]),
                Double.parseDouble(truckData[3]));
        vehicles.put(truckData[0], truck);

        String[] bussData = scanner.nextLine().split("\\s+");
        Vehicle buss = new Bus(Double.parseDouble(bussData[1]),
                Double.parseDouble(bussData[2]),
                Double.parseDouble(bussData[3]));
        vehicles.put(bussData[0], buss);

        return vehicles;
    }
}

