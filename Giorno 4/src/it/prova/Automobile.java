package it.prova;

public class Automobile {
	protected String modello;
	protected int velocita;

	public Automobile() {
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public void modello1() {
		System.out.println("Sono in Automobile");
	}
}
