package BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        List<Identifiable> list = new ArrayList<>();
        while (!line.equals("End")) {
            String[] parts = line.split("\\s+");
            if (parts.length > 2) {
                Citizen citizen = new Citizen(parts[0], Integer.parseInt(parts[1]), parts[2]);
                list.add(citizen);
            } else {
                Robot robot = new Robot(parts[0], parts[1]);
                list.add(robot);
            }
            line = scanner.nextLine();
        }

        String finalLine = scanner.nextLine();
        list.stream().filter(e -> e.getId().endsWith(finalLine)).forEach(e -> System.out.println(e.getId()));
    }
}
