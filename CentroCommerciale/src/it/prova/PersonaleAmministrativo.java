package it.prova;

public class PersonaleAmministrativo extends Lavoratore {

	public PersonaleAmministrativo(String nome, String cognome, String numeroMatricola, Negozio negozio) {
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

		for (Item item : negozio.getItems()) {
			if (oggetto.getNumeroSeriale().equals(item.getNumeroSeriale())) {
				negozio.getItems().remove(negozio.getItems().indexOf(oggetto));
				return true;
			}
		}
		return false;
	}

}
