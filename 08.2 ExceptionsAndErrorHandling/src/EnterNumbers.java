import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EnterNumbers {
    static List<String> numbers = new ArrayList<>();
    static int start = 1;
    static final int end = 100;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (numbers.size() < 10) {
            try {
                readNumber(start, end);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(String.join(", ", numbers));

    }

    public static void readNumber(int startNumber, int endNumber) throws IllegalArgumentException {
        String numberStr = scanner.nextLine();
        validateNumber(numberStr);
        numbers.add(numberStr);
        start = Integer.parseInt(numberStr);
    }

    private static void validateNumber(String numberStr) {
        int number;
        try {
            number = Integer.parseInt(numberStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid Number!");
        }
        if (number <= start || number >= end) {
            throw new IllegalArgumentException("Your number is not in range " + start + " - 100!");
        }
    }
}
