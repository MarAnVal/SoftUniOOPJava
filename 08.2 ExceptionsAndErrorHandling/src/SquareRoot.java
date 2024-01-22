import java.util.Map;
import java.util.Scanner;

public class SquareRoot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numberStr = scanner.nextLine();
        try {
            System.out.printf("%.2f%n", getResult(numberStr));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Goodbye");
        }
    }

    private static double getResult(String numberStr) throws IllegalArgumentException {
        int number;
        try{
            number=Integer.parseInt(numberStr);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("Invalid");
        }
        if (number < 0) {
            throw new IllegalArgumentException("Invalid");
        }
        return Math.sqrt(number);
    }
}
