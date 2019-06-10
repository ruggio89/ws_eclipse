package it.prova.test;

import javax.swing.JOptionPane;

import it.prova.utility.Utility;

public class TestUtility {
	public static void main(String[] args) {
		String numeroStringa = "50";
		
//		System.out.println(Utility.parseFromStringToInt(numeroStringa));
		
		
		
		String messaggio = JOptionPane.showInputDialog("Dammi il numero");
		
		while(Utility.parseFromStringToInt(messaggio) != Utility.parseFromStringToInt(numeroStringa)) {
			JOptionPane.showMessageDialog(null, "Ritenta");
			JOptionPane.showInputDialog("Dammi il numero");
		}
		
//		
		
			
		
		
//		
//			JOptionPane.showInputDialog("Dammi il numero");
//			JOptionPane.showMessageDialog(null, "Ritenta");
		
		
		
		
	}
}
