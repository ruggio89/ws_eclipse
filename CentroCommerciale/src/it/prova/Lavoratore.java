package it.prova;

public abstract class Lavoratore {
	protected String numeroMatricola;
	protected String nome;
	protected String cognome;
	protected Negozio negozio;

	public Lavoratore() {
	}

	
	
	public Lavoratore(String numeroMatricola, String nome, String cognome, Negozio negozio) {
		super();
		this.numeroMatricola = numeroMatricola;
		this.nome = nome;
		this.cognome = cognome;
		this.negozio = negozio;
	}



	public String getNumeroMatricola() {
		return numeroMatricola;
	}

	public void setNumeroMatricola(String numeroMatricola) {
		this.numeroMatricola = numeroMatricola;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Negozio getNegozio() {
		return negozio;
	}

	public void setNegozio(Negozio negozio) {
		this.negozio = negozio;
	}

	abstract public boolean handleItemAdd(Item oggetto);

	abstract public boolean handleItemRemove(Item oggetto);

}
