package it.prova;

public class Hotel {
	private String ragioneSociale;
	private int stelle;
	private Stanza[] stanze;

	public Hotel() {
	}

	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	public int getStelle() {
		return stelle;
	}

	public void setStelle(int stelle) {
		this.stelle = stelle;
	}

	public Stanza[] getStanze() {
		return stanze;
	}

	public void setStanze(Stanza[] stanze) {
		this.stanze = stanze;
	}

	public int calcolaConto(Stanza input) {
		int somma = 0;
//		Cliente[] arr = new Cliente[input.getClienti().length];
		for (int i = 0; i < input.getClienti().length; i++) {
			somma += input.getClienti()[i].sommaRealeDaPagare();

		}
		return somma;
	}

}
