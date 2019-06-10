package it.prova.gestionecontribuentespringjpa.utility;

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

	public static Long parseFromStrinToLong(String input) {
		if (input == null)
			return null;

		Long result = null;

		try {
			result = Long.parseLong(input);
		} catch (NumberFormatException e) {
			result = null;
		}
		return result;
	}
}
