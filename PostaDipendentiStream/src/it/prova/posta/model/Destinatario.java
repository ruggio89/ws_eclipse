package it.prova.posta.model;

public class Destinatario {

	private Long id;
	private String nome;
	private String cognome;
	private int eta;
	private String indirizzo;
	private boolean possessoreCC;
	private PostaDiPaese postaDiPaese;

	public Destinatario(String nome, String cognome, int eta, String indirizzo, boolean possessoreCC) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
		this.indirizzo = indirizzo;
		this.possessoreCC = possessoreCC;
	}

	public Destinatario() {
		super();
	}

	public Destinatario(Long id, String nome, String cognome, int eta, String indirizzo, boolean possessoreCC,
			PostaDiPaese postaDiPaese) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
		this.indirizzo = indirizzo;
		this.possessoreCC = possessoreCC;
		this.postaDiPaese = postaDiPaese;
	}
	
	

	public Destinatario(String nome, String cognome, int eta, String indirizzo, boolean possessoreCC,
			PostaDiPaese postaDiPaese) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
		this.indirizzo = indirizzo;
		this.possessoreCC = possessoreCC;
		this.postaDiPaese = postaDiPaese;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public boolean isPossessoreCC() {
		return possessoreCC;
	}

	public void setPossessoreCC(boolean possessoreCC) {
		this.possessoreCC = possessoreCC;
	}

	public PostaDiPaese getPostaDiPaese() {
		return postaDiPaese;
	}

	public void setPostaDiPaese(PostaDiPaese postaDiPaese) {
		this.postaDiPaese = postaDiPaese;
	}

	@Override
	public String toString() {
		return "Destinatario [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", eta=" + eta + ", indirizzo="
				+ indirizzo + ", possessoreCC=" + possessoreCC + "]";
	}
	
	
}
