import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());

        System.out.println(getRhombusRow(n));
    }

    public static String getRhombusRow(int numberOfStars) {
        StringBuilder text = new StringBuilder();
        String space = " ";
        String star = "*";
        for (int i = 1; i < numberOfStars; i++) {
            for (int j = 0; j < numberOfStars - i; j++) {
                text.append(space);
            }
            for (int j = 0; j < i; j++) {
                text.append(String.format("%s ", star));
            }
            text.append(System.lineSeparator());
        }
        for (int i = numberOfStars; i > 0; i--) {
            for (int j = numberOfStars - i; j > 0; j--) {
                text.append(space);
            }
            for (int j = i; j > 0; j--) {
                text.append(String.format("%s ", star));
            }
            text.append(System.lineSeparator());
        }
        return text.toString();
    }
}
