package it.prova.ebayspringjpa.model.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import it.prova.ebayspringjpa.model.Annuncio;
import it.prova.ebayspringjpa.model.Categoria;

public class CategoriaDTO {

	private Long id;
	private String descrizione;
	private String codice;
	private Set<Annuncio> annunci = new HashSet<>(0);

	public CategoriaDTO() {

	}

	public CategoriaDTO(String descrizione, String codice, Set<Annuncio> annunci) {
		super();
		this.descrizione = descrizione;
		this.codice = codice;
		this.annunci = annunci;
	}

	public CategoriaDTO(Long id, String descrizione, String codice, Set<Annuncio> annunci) {
		super();
		this.id = id;
		this.descrizione = descrizione;
		this.codice = codice;
		this.annunci = annunci;
	}

	public CategoriaDTO(Long id, String descrizione, String codice) {
		super();
		this.id = id;
		this.descrizione = descrizione;
		this.codice = codice;
	}

	public CategoriaDTO(String descrizione, String codice) {
		super();
		this.descrizione = descrizione;
		this.codice = codice;
	}

	public static Categoria buildCategoriaInstance(CategoriaDTO input) {
		Categoria result = new Categoria();

		result.setDescrizione(input.getDescrizione());
		result.setCodice(input.getCodice());
		result.setAnnunci(input.getAnnunci());

		return result;
	}
	
	public static CategoriaDTO buildCategoriaDTOInstance(Categoria input) {
		CategoriaDTO result = new CategoriaDTO();

		result.setDescrizione(input.getDescrizione());
		result.setCodice(input.getCodice());
		result.setAnnunci(input.getAnnunci());

		return result;
	}
	
	public List<String> validate() {
		List<String> listaErrori = new ArrayList<String>();

		if (StringUtils.isEmpty(this.descrizione)) {
			listaErrori.add("Inserire correttamente campo nome");
		}
		if (StringUtils.isEmpty(this.codice)) {
			listaErrori.add("Inserire correttamente campo cognome");
		}
		return listaErrori;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public Set<Annuncio> getAnnunci() {
		return annunci;
	}

	public void setAnnunci(Set<Annuncio> annunci) {
		this.annunci = annunci;
	}
	
	
}
