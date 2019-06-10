package it.prova;

public class Padre {
	protected String nome;
	protected String cognome;
	
	public Padre() {}
	
	public void metodo1() {
		System.out.println("Sono in padre");
	}
	
	public static int contaQuantiPadri(Padre[] input) {
		int contatore = 0;
		for (int i = 0; i < input.length; i++) {
			if(input[i] instanceof Padre && input[i] instanceof Figlio == false) {
				contatore ++;
			}
		}
		return contatore;
	}
	
	public static int contaQuantiFigli(Padre[] input) {
		int contatore = 0;
		for (int i = 0; i < input.length; i++) {
			if(input[i] instanceof Figlio) {
				contatore ++;
			}
		}
		return contatore;
	}
}
