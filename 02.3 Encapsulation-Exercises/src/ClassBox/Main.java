package ClassBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double length = Double.parseDouble(scanner.nextLine());
        double width = Double.parseDouble(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());
        Box box = null;
        try {
            box = new Box(length, width, height);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (box != null) {
            StringBuilder text = new StringBuilder();
            text.append(String.format("Surface Area - %.2f", box.calculateSurfaceArea()));
            text.append(System.lineSeparator());
            text.append(String.format("Lateral Surface Area - %.2f", box.calculateLateralSurfaceArea()));
            text.append(System.lineSeparator());
            text.append(String.format("Volume – %.2f", box.calculateVolume()));
            System.out.println(text);
        }
    }
}
