package it.prova.gestionecontribuentespringjpa.model.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.prova.gestionecontribuentespringjpa.model.CartellaEsattoriale;
import it.prova.gestionecontribuentespringjpa.model.Contribuente;

public class ContribuenteDTO {

	private Long id;
	private String nome;
	private String cognome;
	private String codiceFiscale;
	private String indirizzo;
	private Set<CartellaEsattoriale> cartelleEsattoriali = new HashSet<>();

	public ContribuenteDTO() {
		super();
	}

	public List<String> validate() {
		List<String> listaErrori = new ArrayList<String>();

		if (nome.equals("") || nome == null) {
			listaErrori.add("Inserire correttamente campo nome");
		}
		if (cognome.equals("") || cognome == null) {
			listaErrori.add("Inserire correttamente campo cognome");
		}
		if (codiceFiscale.equals("") || codiceFiscale == null) {
			listaErrori.add("Inserire correttamente campo codice fiscale");
		}
		if (indirizzo.equals("") || indirizzo == null) {
			listaErrori.add("Inserire correttamente campo indirizzo");
		}
		return listaErrori;
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

	public static Contribuente buildContribuenteInstance(ContribuenteDTO input) {
		Contribuente result = new Contribuente();

		result.setNome(input.getNome());
		result.setCognome(input.getCognome());
		result.setCodiceFiscale(input.getCodiceFiscale());
		result.setIndirizzo(input.getIndirizzo());

		return result;
	}

}
