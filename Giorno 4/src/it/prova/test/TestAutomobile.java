package it.prova.test;

import it.prova.Automobile;
import it.prova.Ferrari;

public class TestAutomobile {

	public static void main(String[] args) {
		Automobile a1 = new Automobile();
		Automobile a2 = new Ferrari();
		Ferrari m1 = new Ferrari();

		m1.setModello("F555");
		System.out.println(m1.getModello());

		m1.modello1();
		a2.modello1();
		a1.modello1();
		
		m1.setTempi(2);
		System.out.println(m1.getTempi());

	}

}
