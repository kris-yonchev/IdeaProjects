package reflectionsAndAnnotationsExercise.harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Class<RichSoilLand> richSoilLand = RichSoilLand.class;

		String input = scanner.nextLine();
		Field[] fields = richSoilLand.getDeclaredFields();

		while (!input.equals("HARVEST")) {

			switch (input) {
				case "protected":
					Arrays.stream(fields).filter(f -> Modifier.isProtected(f.getModifiers())).forEach(Main::print);
					break;
				case "private":
					Arrays.stream(fields).filter(f -> Modifier.isPrivate(f.getModifiers())).forEach(Main::print);
					break;
				case "public":
					Arrays.stream(fields).filter(f -> Modifier.isPublic(f.getModifiers())).forEach(Main::print);
					break;
				case "all":
					Arrays.stream(fields).forEach(Main::print);
					break;
			}




			input = scanner.nextLine();
		}
	}

	private static void print(Field field) {
		System.out.printf("%s %s %s\n",
				Modifier.toString(field.getModifiers()),
				field.getType().getSimpleName(),
				field.getName());
	}
}
