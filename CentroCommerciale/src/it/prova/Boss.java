package it.prova;

public class Boss extends Lavoratore {

	public Boss(String nome, String cognome, String numeroMatricola, Negozio negozio) {
		this.nome = nome;
		this.cognome = cognome;
		this.numeroMatricola = numeroMatricola;
		this.negozio = negozio;
	}

	@Override
	public boolean handleItemAdd(Item oggetto) {

		return false;
	}

	@Override
	public boolean handleItemRemove(Item oggetto) {

		return false;
	}

}
