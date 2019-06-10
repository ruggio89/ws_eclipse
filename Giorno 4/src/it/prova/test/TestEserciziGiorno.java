package it.prova.test;

import it.prova.EserciziGiornoQuattro;

public class TestEserciziGiorno {

	public static void main(String[] args) {
		int[] arr1 = {12, 3, 45, 8};
		int[] arr2 = {20, 14, 9, 5};
		int num = 2;
		
		/*int[] res1 = EserciziGiornoQuattro.creaUnione(arr1, arr2);
		System.out.println(res1[0]);
		System.out.println(res1[1]);
		System.out.println(res1[2]);
		System.out.println(res1[3]);
		System.out.println(res1[4]);
		System.out.println(res1[5]);
		System.out.println(res1[6]);
		System.out.println(res1[7]);*/
		
		/*int[] res2 = EserciziGiornoQuattro.calcolaScalare(num, arr2);
		System.out.println(res2[0]);
		System.out.println(res2[1]);
		System.out.println(res2[2]);
		System.out.println(res2[3]);*/
		
		if(EserciziGiornoQuattro.verificaMaggioreSuccessivo(arr2)) {
			System.out.println("Array decrescente");
		} else {
			System.out.println("NO");
		}
		
		
	}

}
