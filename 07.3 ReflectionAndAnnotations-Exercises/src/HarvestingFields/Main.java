package HarvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String command = scanner.nextLine();
		Class<?> richSoilLandClass = RichSoilLand.class;
		Field[] declaredFields = richSoilLandClass.getDeclaredFields();

		while (!"HARVEST".equals(command)){
			for (Field declaredField : declaredFields){
				if(command.equals("all") ||
						command.equals(getAccessModifierName(declaredField.getModifiers()))){
					System.out.println(getAccessModifierName(declaredField.getModifiers()) +
							" " + declaredField.getType().getSimpleName() +
							" " + declaredField.getName());
				}
			}
			command = scanner.nextLine();
		}
	}

	private static String getAccessModifierName(int modifiers) {
		String modifierName;
		if (Modifier.isPublic(modifiers)) {
			modifierName = "public";
		} else if (Modifier.isProtected(modifiers)) {
			modifierName = "protected";
		} else if (Modifier.isPrivate(modifiers)) {
			modifierName = "private";
		} else {
			throw new IllegalArgumentException("Expected to be either public, private or protected");
		}
		return modifierName;
	}
}
