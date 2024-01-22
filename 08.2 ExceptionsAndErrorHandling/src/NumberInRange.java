import java.util.Scanner;

public class NumberInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String range = scanner.nextLine();
        System.out.printf("Range: [%s...%s]%n", range.split("\\s+")[0], range.split("\\s+")[1]);
        boolean end = false;
        while (!end) {
            String input = scanner.nextLine();
            try {
                end = parseNumberInRange(range, input);
                System.out.println("Valid number: " + input);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid number: " + input);
            }

        }
    }

    private static boolean parseNumberInRange(String range, String input) throws IllegalArgumentException {
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }
        int startNumber = Integer.parseInt(range.split("\\s+")[0]);
        int endNumber = Integer.parseInt(range.split("\\s+")[1]);
        if (number < startNumber || number > endNumber) {
            throw new IllegalArgumentException();
        }
        return true;
    }
}
