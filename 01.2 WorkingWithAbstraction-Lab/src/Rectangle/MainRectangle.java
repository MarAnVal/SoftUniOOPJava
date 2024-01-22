package Rectangle;

import java.util.Arrays;
import java.util.Scanner;

public class MainRectangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] rectanglePoints = Arrays.stream(input.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        Point pointDown = new Point(rectanglePoints[0], rectanglePoints[1]);
        Point pointUp = new Point(rectanglePoints[2], rectanglePoints[3]);
        Rectangle rectangle = new Rectangle(pointDown, pointUp);

        int n = Integer.parseInt(input.nextLine());
        for (int i = 0; i < n; i++) {
            int[] line = Arrays.stream(input.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            Point point = new Point(line[0], line[1]);
            System.out.println(rectangle.contains(point));
        }
    }
}
