package it.prova.utility;

public class Utility {
	
	public static Integer parseFromStringToInt(String input) {
		Integer result = null;
		try {
			result = Integer.parseInt(input);
		} catch(NumberFormatException exc) {
			result = null;
		}
		return result;
	}
	
}
