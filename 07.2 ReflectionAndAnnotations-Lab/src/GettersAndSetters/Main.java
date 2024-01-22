package GettersAndSetters;

import java.lang.reflect.Method;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Class<?> reflection = Reflection.class;
        Method[] allMethods = reflection.getDeclaredMethods();

        Arrays.stream(allMethods).filter(Main::isGetter)
                .sorted((l, r) -> l.getName().compareTo(r.getName()))
                .forEach(m -> System.out.printf("%s will return class %s%n", m.getName(), m.getReturnType().getName()));
        ;
        Arrays.stream(allMethods).filter(Main::isSetter)
                .sorted((l, r) -> l.getName().compareTo(r.getName()))
                .forEach(m -> System.out.printf("%s and will set field of class %s%n", m.getName(), m.getParameterTypes()[0].getName()));


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
