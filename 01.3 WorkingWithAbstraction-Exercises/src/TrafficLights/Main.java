package TrafficLights;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split("\\s+");
        TrafficLight[] trafficLights = new TrafficLight[line.length];
        for (int i = 0; i < line.length; i++) {
            String s = line[i];
            TrafficLight.Signals signal = TrafficLight.Signals.valueOf(s);
            TrafficLight t = new TrafficLight(signal);
            trafficLights[i] = t;
        }
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            update(trafficLights);
            print(trafficLights);
        }

    }

    public static void update(TrafficLight[] trafficLights) {
        for (TrafficLight trafficLight : trafficLights) {
            trafficLight.update();
        }
    }
    public static void print(TrafficLight[] trafficLights){
        for (TrafficLight trafficLight : trafficLights) {
            System.out.print(trafficLight.getSignal() + " ");
        }
        System.out.println();
    }
}
