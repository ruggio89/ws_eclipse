package id.prova.model;

public class Cd {
	private Long id;
	private String titolo;
	private String genere;
	private String traccia;
	private Autore autore = new Autore();

	public Cd() {
	}

	public Cd(String titolo, String genere, String traccia, Autore autore) {
		super();
		this.titolo = titolo;
		this.genere = genere;
		this.traccia = traccia;
		this.autore = autore;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public String getTraccia() {
		return traccia;
	}

	public void setTraccia(String traccia) {
		this.traccia = traccia;
	}

	public Autore getAutore() {
		return autore;
	}

	public void setAutore(Autore autore) {
		this.autore = autore;
	}
	
	@Override
	public String toString() {
		return "Cd [titolo=" + titolo + ", genere=" + genere + ", traccia=" + traccia + ", autore=" + autore + "]";
	}
}
