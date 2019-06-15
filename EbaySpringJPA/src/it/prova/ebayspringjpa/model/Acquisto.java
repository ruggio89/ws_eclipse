package it.prova.ebayspringjpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "acquisto")
public class Acquisto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	private String descrizione;
	private Integer anno;
	private double prezzo;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "utente_id", nullable = false)
	private Utente utente;
	
	public Acquisto() {
		
	}

	public Acquisto(String descrizione, Integer anno, double prezzo, Utente utente) {
		super();
		this.descrizione = descrizione;
		this.anno = anno;
		this.prezzo = prezzo;
		this.utente = utente;
	}

	public Acquisto(String descrizione, Integer anno, double prezzo) {
		super();
		this.descrizione = descrizione;
		this.anno = anno;
		this.prezzo = prezzo;
	}

	public Acquisto(String descrizione, Integer anno) {
		super();
		this.descrizione = descrizione;
		this.anno = anno;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Integer getAnno() {
		return anno;
	}

	public void setAnno(Integer anno) {
		this.anno = anno;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	
	
	
	
}
