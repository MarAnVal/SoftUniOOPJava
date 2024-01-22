package AnimalFarm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);
        String name = scaner.nextLine();
        int age = Integer.parseInt(scaner.nextLine());
        Chicken chicken = null;
        try {
            chicken = new Chicken(name, age);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        if (chicken != null) {
            System.out.println(chicken);
        }
    }
}
