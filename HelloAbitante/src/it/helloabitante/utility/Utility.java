package it.helloabitante.utility;

public class Utility {
	public static Integer parseFromStrinToInt(String input) {
		if (input == null || input.isEmpty())
			return null;

		Integer result = null;

		try {
			result = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			result = null;
		}
		return result;
	}
}
