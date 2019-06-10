package it.prova;

public class Commesso extends Lavoratore {

	public Commesso(String nome, String cognome, String numeroMatricola, Negozio negozio) {
		this.nome = nome;
		this.cognome = cognome;
		this.numeroMatricola = numeroMatricola;
		this.negozio = negozio;
	}

	@Override
	public boolean handleItemAdd(Item oggetto) {

		for (Item item : negozio.getItems()) {
			if (oggetto.getNumeroSeriale().equals(item.getNumeroSeriale())) {
				return false;
			}
		}
		negozio.getItems().add(oggetto);
		return true;
	}

	@Override
	public boolean handleItemRemove(Item oggetto) {
		
		for (Item item : this.getNegozio().getItems()) {
			if (oggetto.getNumeroSeriale().equals(item.getNumeroSeriale())) {
				this.getNegozio().getItems().remove(oggetto);
				return true;
			}
		}
		return false;
	}

}
