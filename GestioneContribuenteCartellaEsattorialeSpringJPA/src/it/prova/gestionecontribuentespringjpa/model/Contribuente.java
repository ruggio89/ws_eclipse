package it.prova.gestionecontribuentespringjpa.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Contribuente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String cognome;
	private String codiceFiscale;
	private String indirizzo;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, mappedBy = "contribuente", orphanRemoval = true)
	private Set<CartellaEsattoriale> cartelleEsattoriali = new HashSet<>();

	public Contribuente() {
		super();
	}

	public Contribuente(Long id) {
		super();
		this.id = id;
	}

	public Contribuente(String nome, String cognome, String codiceFiscale) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
	}

	public Contribuente(Long id, String nome, String cognome, String codiceFiscale, String indirizzo,
			Set<CartellaEsattoriale> cartelleEsattoriali) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
		this.indirizzo = indirizzo;
		this.cartelleEsattoriali = cartelleEsattoriali;
	}

	public Contribuente(String nome, String cognome) {
		super();
		this.nome = nome;
		this.cognome = cognome;
	}

	public Contribuente(String nome, String cognome, String codiceFiscale, String indirizzo,
			Set<CartellaEsattoriale> cartelleEsattoriali) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
		this.indirizzo = indirizzo;
		this.cartelleEsattoriali = cartelleEsattoriali;
	}

	public Contribuente(String nome, String cognome, String codiceFiscale, String indirizzo) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
		this.indirizzo = indirizzo;
	}

	public Contribuente(Long id, String nome, String cognome, String codiceFiscale, String indirizzo) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
		this.indirizzo = indirizzo;
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

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public Set<CartellaEsattoriale> getCartelleEsattoriali() {
		return cartelleEsattoriali;
	}

	public void setCartelleEsattoriali(Set<CartellaEsattoriale> cartelleEsattoriali) {
		this.cartelleEsattoriali = cartelleEsattoriali;
	}

}
