package JediGalaxy;
//workingWithAbstraction.

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Galaxy galaxy = readGalaxy(scanner);
        String command = scanner.nextLine();
        long sum = 0;
        while (!command.equals("Let the Force be with you")) {
            int[] jediCoordinates = Arrays.stream(command.split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            int[] evilCoordinates = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            sum += calculateSum(galaxy,
                    new Coordinates(jediCoordinates[0], jediCoordinates[1]),
                    new Coordinates(evilCoordinates[0], evilCoordinates[1]));
            command = scanner.nextLine();
        }
        System.out.println(sum);
    }

    private static long calculateSum(Galaxy galaxy, Coordinates jediCoords, Coordinates evilCoords) {
        moveEvilAndDestroyStars(galaxy, evilCoords);
        return moveJediAndCalculateStars(galaxy, jediCoords);
    }

    private static long moveJediAndCalculateStars(Galaxy galaxy, Coordinates jediCoords) {
        long sum = 0;
        while (couldJediMove(galaxy, jediCoords)) {
            if (galaxy.isInside(jediCoords)) {
                sum += galaxy.starValue(jediCoords);
            }
            jediCoords.row--;
            jediCoords.col++;
        }
        return sum;
    }

    private static boolean couldJediMove(Galaxy galaxy, Coordinates jediCoords) {
        return jediCoords.row >= 0 && jediCoords.col < galaxy.numCols;
    }

    private static void moveEvilAndDestroyStars(Galaxy galaxy, Coordinates evilCoords) {
        while (couldEvilMove(evilCoords)) {
            if (galaxy.isInside(evilCoords)) {
                galaxy.destroyStar(evilCoords);
            }
            evilCoords.row--;
            evilCoords.col--;
        }
    }

    private static boolean couldEvilMove(Coordinates evilCoords) {
        return evilCoords.row >= 0 && evilCoords.col >= 0;
    }

    static Galaxy readGalaxy(Scanner scanner) {
        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int x = dimensions[0];
        int y = dimensions[1];

        int[][] galaxyMatrix = new int[x][y];

        int value = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                galaxyMatrix[i][j] = value++;
            }
        }
        return new Galaxy(galaxyMatrix);
    }
}
