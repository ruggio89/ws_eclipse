package it.prova.model;

public class MateriaPrima {
	private int id;
	private String descrizione;
	private StatoMateria stato;

	public MateriaPrima(int id, String descrizione) {
		this.id = id;
		this.descrizione = descrizione;
	}

	public MateriaPrima(int id, String descrizione, StatoMateria stato) {
		this.id = id;
		this.descrizione = descrizione;
		this.stato = stato;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public StatoMateria getStato() {
		return stato;
	}

	public void setStato(StatoMateria stato) {
		this.stato = stato;
	}

	@Override
	public String toString() {
		return "MateriaPrima [id=" + id + ", descrizione=" + descrizione + ", stato=" + stato + "]";
	}
	
	
}
