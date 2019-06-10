package it.prova.test;

import it.prova.UtilityString;

public class TestUtilityString {

	public static void main(String[] args) {
		String nome = "RuggeroRossi";
		String[] str1 = {"rosso", "giallo", "amaranto"};
		String[] str2 = {"figlio", "padre", "gemello"};
		int[] arr1 = {1, 2, 3, 4};
		int[] arr2 = {5, 6, 7, 8};

		System.out.println(UtilityString.stringaAlContrario(nome));
		
		if(UtilityString.isPalindromo(nome)) {
			System.out.println("Palindromo");
		} else {
			System.out.println("Non Palindromo");
		}
		
		if(UtilityString.arrLunghezzaIesima(str1, str2)) {
			System.out.println("Lunghezza i-esima uguale");
		} else {
			System.out.println("Lunghezza i-esima diversa");
		}
		
	

	}
	
	

}
