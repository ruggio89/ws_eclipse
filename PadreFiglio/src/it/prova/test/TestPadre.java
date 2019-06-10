package it.prova.test;

import it.prova.Figlio;
import it.prova.Padre;

public class TestPadre {
	public static void main(String[] args) {
		Padre p1 = new Padre();
		p1.metodo1();
		
		Figlio f1 = new Figlio();
		f1.metodo1();
		
		Figlio f2 = new Figlio();
		Figlio f3 = new Figlio();
		
		Padre p2 = new Figlio();
		p2.metodo1();
		
		Padre p3 = new Padre();
		
		Padre[] arrP = {p1, f1, p3, f2, p2, f3};
		System.out.println(Padre.contaQuantiPadri(arrP));
		
		
		System.out.println(Padre.contaQuantiFigli(arrP));
		
	}
}
