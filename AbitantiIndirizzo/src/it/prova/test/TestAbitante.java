package it.prova.test;

import it.prova.Abitante;
import it.prova.Indirizzo;

public class TestAbitante {

	public static void main(String[] args) {
		Abitante a1 = new Abitante();

		a1.setNome("Ruggero");
		a1.setCognome("Rossi");
		a1.setEta(29);

		Indirizzo i1 = new Indirizzo();

		i1.setCitta("Roma");
		i1.setCivico("45");
		i1.setVia("Via Mosca");

		a1.setIndirizzo(i1);

		System.out.println(a1.getNome());
		System.out.println(a1.getCognome());
		System.out.println(a1.getEta());
		System.out.println(a1.getIndirizzo().getVia());
		System.out.println(a1.getIndirizzo().getCivico());
		System.out.println(a1.getIndirizzo().getCitta());

	}

}
