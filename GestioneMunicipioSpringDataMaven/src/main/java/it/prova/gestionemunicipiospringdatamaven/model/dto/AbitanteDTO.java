package it.prova.gestionemunicipiospringdatamaven.model.dto;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import it.prova.gestionemunicipiospringdatamaven.model.Abitante;
import it.prova.gestionemunicipiospringdatamaven.model.Municipio;

public class AbitanteDTO {

	private Long id;
	private String nome;
	private String cognome;
	private Integer eta;
	private String residenza;
	private Municipio municipio;

	public AbitanteDTO() {

	}

	public AbitanteDTO(String nome, String cognome, Integer eta, String residenza) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
		this.residenza = residenza;
	}

	public AbitanteDTO(String nome, String cognome, Integer eta, String residenza, Municipio municipio) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
		this.residenza = residenza;
		this.municipio = municipio;
	}

	public AbitanteDTO(Long id, String nome, String cognome, Integer eta, String residenza, Municipio municipio) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
		this.residenza = residenza;
		this.municipio = municipio;
	}
	
	public List<String> validate() {
		List<String> listaErrori = new ArrayList<String>();

		if (StringUtils.isEmpty(this.nome)) {
			listaErrori.add("Inserire correttamente campo nome");
		}
		if (StringUtils.isEmpty(this.cognome)) {
			listaErrori.add("Inserire correttamente campo cognome");
		}
		if (StringUtils.isEmpty(this.residenza)) {
			listaErrori.add("Inserire correttamente campo residenza");
		}
		if (eta < 0) {
			listaErrori.add("Inserire correttamente campo eta");
		}
		return listaErrori;
	}
	
	public static Abitante buildAbitanteInstance(AbitanteDTO input) {
		Abitante result = new Abitante();
		
		result.setNome(input.getNome());
		result.setCognome(input.getCognome());
		result.setResidenza(input.getResidenza());
		result.setEta(input.getEta());
		result.setMunicipio(input.getMunicipio());
		
		return result;
	}
	
	public static AbitanteDTO buildAbitanteDTOInstance(Abitante input) {
		AbitanteDTO result = new AbitanteDTO();
		
		result.setNome(input.getNome());
		result.setCognome(input.getCognome());
		result.setResidenza(input.getResidenza());
		result.setEta(input.getEta());
		result.setMunicipio(input.getMunicipio());
		
		return result;
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

	public Integer getEta() {
		return eta;
	}

	public void setEta(Integer eta) {
		this.eta = eta;
	}

	public String getResidenza() {
		return residenza;
	}

	public void setResidenza(String residenza) {
		this.residenza = residenza;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	@Override
	public String toString() {
		return "Abitante [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", eta=" + eta + ", residenza="
				+ residenza + "]";
	}
}
