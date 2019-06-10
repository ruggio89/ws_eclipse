package it.prova;

public class EserciziGiornoQuattro {
	
	public static int[] creaUnione(int[] input1, int[] input2) {
		int[] result = new int[input1.length + input2.length];
		for (int i = 0; i < input1.length; i++) {
			result[i] = input1[i];
		}
		for (int i = 0; i < input1.length; i++) {
			result[input1.length + i] = input2[i];
		}
		return result;
	}
	
	public static int[] calcolaScalare(int input1, int[] input2) {
		int[] result = new int[input2.length];
		for (int i = 0; i < input2.length; i++) {
			result[i] = input1 * input2[i];
		}
		return result;
	}
	
	public static boolean verificaMaggioreSuccessivo(int[] input) {
		if(input == null) {
			return false;
		}
		for (int i = 1; i < input.length; i++) {
			if(input[i] > input[i-1]) {
				return false;
			}
		}
		return true;
	}
}
