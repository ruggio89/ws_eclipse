package it.prova;

public class UtilityString {

	public static String stringaAlContrario(String input) {
		String result = "";
		for (int i = input.length() - 1; i >= 0; i--) {
			result += input.charAt(i);
		}
		return result;
	}

	public static boolean isPalindromo(String input) {
		if (input == null) {
			return false;
		}
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	public static boolean arrLunghezzaIesima(String[] input1, String[] input2) {
		if (input1 == null || input2 == null || input1.length != input2.length) {
			return false;
		}
		for (int i = 0; i < input2.length; i++) {
			if (input1[i].length() != input2[i].length()) {
				return false;
			}
		}
		return true;
	}

	
}
