package HighQualityMistakes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Class<?> reflection = Reflection.class;
        Method[] allMethods = reflection.getDeclaredMethods();
        Field[] allField = reflection.getDeclaredFields();

        Arrays.stream(allField)
                .filter(f -> !Modifier.isPrivate(f.getModifiers()))
                .sorted(Comparator.comparing(Field::getName))
                .forEach(f -> System.out.printf("%s must be private!%n", f.getName()));

        Arrays.stream(allMethods).filter(Main::isGetter)
                .sorted(Comparator.comparing(Method::getName))
                .filter(m -> !Modifier.isPublic(m.getModifiers()))
                .forEach(m -> System.out.printf("%s have to be public!%n", m.getName()));
        ;
        Arrays.stream(allMethods).filter(Main::isSetter)
                .sorted(Comparator.comparing(Method::getName))
                .filter(m -> !Modifier.isPrivate(m.getModifiers()))
                .forEach(m -> System.out.printf("%s have to be private!%n", m.getName()));
    }

    private static boolean isGetter(Method m) {
        if (m.getName().startsWith("get") &&
                m.getParameterCount() == 0 &&
                !m.getReturnType().equals(void.class)) {
            return true;
        }
        return false;
    }

    private static boolean isSetter(Method m) {
        if (m.getName().startsWith("set") &&
                m.getParameterCount() == 1 &&
                m.getReturnType().equals(void.class)) {
            return true;
        }
        return false;
    }
}
