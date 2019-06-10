package it.prova.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

import it.prova.Persona;

public class Test1 {

	public static void main(String[] args) {

		List<String> listaStringa = new ArrayList();

		listaStringa.add("Ruggero");
		listaStringa.add("Giacomo");
		listaStringa.add("Elio");

		System.out.println(listaStringa.get(0));
		System.out.println(listaStringa.get(1));
		System.out.println(listaStringa.get(2));

		for (String item : listaStringa) {
			if (item.equals("Ruggero")) {
				System.out.println(item);
			}
		}

		System.out.println(esiste(listaStringa, "Pino"));

		List<Persona> listaPersone = Arrays.asList(new Persona("Ruggero", "Rossi"), new Persona("Marco", "Bianchi"),
				new Persona("Roberto", "Verdi"));

		System.out.println(quantePersoneCarattereIniziale(listaPersone, 'R'));

		Persona person = new Persona(JOptionPane.showInputDialog("Ruggero"), JOptionPane.showInputDialog("Rossi"));

	} 

	public static boolean esiste(List<String> listaConfronto, String input) {
		for (String item : listaConfronto) {
			if (item.equals(input)) {
				return true;
			}
		}
		return false;

	}

	public static int quantePersoneCarattereIniziale(List<Persona> listaConfronto, char carattereConfronto) {
		int contatore = 0;
		for (Persona item : listaConfronto) {
			if (carattereConfronto == item.getNome().charAt(0)) {
				contatore++;
			}
		}
		return contatore;
	}
}
