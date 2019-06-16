package it.prova.ebayspringjpa.model.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import it.prova.ebayspringjpa.model.Annuncio;
import it.prova.ebayspringjpa.model.Categoria;
import it.prova.ebayspringjpa.model.Utente;

public class AnnuncioDTO {

	private Long id;
	private boolean apertoChiuso;
	private String testoAnnuncio;
	private Date dataAnnuncio;
	private double prezzo;
	private Utente utente;
	private Set<Categoria> categorie = new HashSet<>(0);

	public AnnuncioDTO() {
		super();
	}

	public List<String> validate() {
		List<String> listaErrori = new ArrayList<String>();

		if (StringUtils.isEmpty(this.testoAnnuncio)) {
			listaErrori.add("Inserire correttamente campo Test Annuncio");
		}
		if (prezzo < 0) {
			listaErrori.add("Inserire correttamente campo Prezzo");
		}
		if ( this.categorie.size() <= 0 ) {
			listaErrori.add("Selezionare almeno una Categoria");
		} 

		return listaErrori;
	}

	public static Annuncio buildAnnuncioIntance(AnnuncioDTO input) {
		Annuncio result = new Annuncio();

		result.setTestoAnnuncio(input.getTestoAnnuncio());
		result.setPrezzo(input.getPrezzo());
		result.setDataAnnuncio(input.getDataAnnuncio());
		result.setApertoChiuso(input.isApertoChiuso());
		result.setCategorie(input.getCategorie());

		return result;
	}

	public static AnnuncioDTO buildAnnuncioDTOIntance(Annuncio input) {
		AnnuncioDTO result = new AnnuncioDTO();

		result.setTestoAnnuncio(input.getTestoAnnuncio());
		result.setPrezzo(input.getPrezzo());
		result.setDataAnnuncio(input.getDataAnnuncio());
		result.setApertoChiuso(input.isApertoChiuso());
		result.setCategorie(input.getCategorie());

		return result;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isApertoChiuso() {
		return apertoChiuso;
	}

	public void setApertoChiuso(boolean apertoChiuso) {
		this.apertoChiuso = apertoChiuso;
	}

	public String getTestoAnnuncio() {
		return testoAnnuncio;
	}

	public void setTestoAnnuncio(String testoAnnuncio) {
		this.testoAnnuncio = testoAnnuncio;
	}

	public Date getDataAnnuncio() {
		return dataAnnuncio;
	}

	public void setDataAnnuncio(Date dataAnnuncio) {
		this.dataAnnuncio = dataAnnuncio;
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

	public Set<Categoria> getCategorie() {
		return categorie;
	}

	public void setCategorie(Set<Categoria> categorie) {
		this.categorie = categorie;
	}

}
