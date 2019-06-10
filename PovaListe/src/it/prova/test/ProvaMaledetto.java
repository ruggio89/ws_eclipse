package it.prova.test;

import javax.swing.JOptionPane;

public class ProvaMaledetto {
	public static void main(String[] args) {
		String s = JOptionPane.showInputDialog("Dammi un valore");
		JOptionPane.showMessageDialog(null, "Hai inserito " + s);
	}
}
