package it.prova.gestionemunicipiospringdatamaven.model.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import it.prova.gestionemunicipiospringdatamaven.model.Abitante;
import it.prova.gestionemunicipiospringdatamaven.model.Municipio;

public class MunicipioDTO {
	
	private Long id;
	private String descrizione;
	private String codice;
	private String ubicazione;
	private Set<Abitante> abitanti = new HashSet<>();

	public MunicipioDTO() {
	}

	public MunicipioDTO(String descrizione, String codice, String ubicazione) {
		super();
		this.descrizione = descrizione;
		this.codice = codice;
		this.ubicazione = ubicazione;
	}
	
	

	public MunicipioDTO(String descrizione, String codice, String ubicazione, Set<Abitante> abitanti) {
		super();
		this.descrizione = descrizione;
		this.codice = codice;
		this.ubicazione = ubicazione;
		this.abitanti = abitanti;
	}

	public MunicipioDTO(Long id, String descrizione, String codice, String ubicazione, Set<Abitante> abitanti) {
		super();
		this.id = id;
		this.descrizione = descrizione;
		this.codice = codice;
		this.ubicazione = ubicazione;
		this.abitanti = abitanti;
	}
	
	public List<String> validate(){
		List<String> listaErrori = new ArrayList<String>();
		
		if (StringUtils.isEmpty(this.descrizione)) {
			listaErrori.add("Inserire correttamente campo descrizione");
		}
		if (StringUtils.isEmpty(this.codice)) {
			listaErrori.add("Inserire correttamente campo codice");
		}
		if (StringUtils.isEmpty(this.ubicazione)) {
			listaErrori.add("Inserire correttamente campo ubicazione");
		}
		return listaErrori;
	}
	
	public static Municipio buildMunicipioInstance(MunicipioDTO input) {
		Municipio result = new Municipio();
		
		result.setDescrizione(input.getDescrizione());
		result.setCodice(input.getCodice());
		result.setUbicazione(input.getUbicazione());
		result.setAbitanti(input.getAbitanti());
		
		return result;
	}
	
	public static MunicipioDTO buildMunicipioDTOInstance(Municipio input) {
		MunicipioDTO result = new MunicipioDTO();
		
		result.setDescrizione(input.getDescrizione());
		result.setCodice(input.getCodice());
		result.setUbicazione(input.getUbicazione());
		result.setAbitanti(input.getAbitanti());
		
		return result;
	}
	
	
	public Set<Abitante> getAbitanti() {
		return abitanti;
	}

	public void setAbitanti(Set<Abitante> abitanti) {
		this.abitanti = abitanti;
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

	public String getUbicazione() {
		return ubicazione;
	}

	public void setUbicazione(String ubicazione) {
		this.ubicazione = ubicazione;
	}
}
