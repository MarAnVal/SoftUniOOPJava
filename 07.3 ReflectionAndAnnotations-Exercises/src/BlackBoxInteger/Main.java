package BlackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Class<BlackBoxInt> blackBoxIntClass = BlackBoxInt.class;

        BlackBoxInt blackBoxInt;
        try {
            Constructor<BlackBoxInt> decleredConstructor = blackBoxIntClass.getDeclaredConstructor();
            decleredConstructor.setAccessible(true);
            blackBoxInt = decleredConstructor.newInstance();
        } catch (NoSuchMethodException |
                 InvocationTargetException |
                 InstantiationException |
                 IllegalAccessException e) {
            throw new IllegalStateException(e);
        }

        String command = scanner.nextLine();
        System.out.println();
        while (!"END".equals(command)) {
            String[] commandParts = command.split("_");
            String methodName = commandParts[0];
            int parameter = Integer.parseInt(commandParts[1]);
            Method decleredMethod;
            try {
                decleredMethod = blackBoxIntClass.getDeclaredMethod(methodName, int.class);
                decleredMethod.setAccessible(true);
                decleredMethod.invoke(blackBoxInt, parameter);

            } catch (NoSuchMethodException |
                     InvocationTargetException |
                     IllegalAccessException e) {
                throw new IllegalStateException();
            }
            int currentValue;
            try {
                Field innerValueField = blackBoxIntClass.getDeclaredField("innerValue");
                innerValueField.setAccessible(true);
                currentValue = innerValueField.getInt(blackBoxInt);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new IllegalStateException();
            }
            System.out.println(currentValue);
            command = scanner.nextLine();
        }
    }
}
