package ShoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> personsList = parsePerson(scanner.nextLine().split(";"));
        List<Product> productsList = parseProduct(scanner.nextLine().split(";"));

        String command = scanner.nextLine();
        while (!command.equals("END")) {
            if (personsList.isEmpty()){
                break;
            }
            String personName = command.split(" ")[0];
            String productName = command.split(" ")[1];
            Person person = personsList.stream().filter(p -> p.getName().equals(personName)).findFirst().get();
            Product product = productsList.stream().filter(p -> p.getName().equals(productName)).findFirst().get();
            try {
                person.buyProduct(product);
                System.out.printf("%s bought %s%n", personName, productName);
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
            command = scanner.nextLine();
        }
        personsList.forEach(e -> System.out.println(e.viewBought()));
    }

    private static List<Person> parsePerson(String[] data) {
        List<Person> persons = new ArrayList<>();
        for (String datum : data) {
            String name = datum.split("=")[0];
            double money = Integer.parseInt(datum.split("=")[1]);
            Person person = null;
            try {
                person = new Person(name, money);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            if (person != null) {
                persons.add(person);
            }
        }
        return persons;
    }

    private static List<Product> parseProduct(String[] data) {
        List<Product> products = new ArrayList<>();
        for (String datum : data) {
            String name = datum.split("=")[0];
            double cost = Integer.parseInt(datum.split("=")[1]);
            Product product = null;
            try {
                product = new Product(name, cost);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            if (product != null) {
                products.add(product);
            }
        }
        return products;
    }
}
