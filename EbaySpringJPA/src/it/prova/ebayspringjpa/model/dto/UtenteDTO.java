package it.prova.ebayspringjpa.model.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import it.prova.ebayspringjpa.model.Acquisto;
import it.prova.ebayspringjpa.model.Annuncio;
import it.prova.ebayspringjpa.model.Ruolo;
import it.prova.ebayspringjpa.model.Utente;

public class UtenteDTO {

	private Long id;
	private String nome;
	private String cognome;
	private String username;
	private String password;
	private Double creditoResiduo;
	private Date dataRegistrazione;
	private Set<Ruolo> ruoli = new HashSet<>(0);
	private Set<Acquisto> acquisti = new HashSet<>(0);
	private Set<Annuncio> annunci = new HashSet<>(0);

	public UtenteDTO() {

	}

	public List<String> validate() {
		List<String> listaErrori = new ArrayList<String>();

		if (StringUtils.isEmpty(this.nome)) {
			listaErrori.add("Inserire correttamente campo nome");
		}
		if (StringUtils.isEmpty(this.cognome)) {
			listaErrori.add("Inserire correttamente campo cognome");
		}
		if (StringUtils.isEmpty(this.username)) {
			listaErrori.add("Inserire correttamente campo codice fiscale");
		}
		if (StringUtils.isEmpty(this.password)) {
			listaErrori.add("Inserire correttamente campo indirizzo");
		}
//		if (creditoResiduo < 0) {
//			listaErrori.add("Inserire correttamente campo credito residuo");
//		}
		return listaErrori;
	}

	public UtenteDTO(String nome, String cognome, String username, String password, Double creditoResiduo,
			Date dataRegistrazione) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
		this.creditoResiduo = creditoResiduo;
		this.dataRegistrazione = dataRegistrazione;
	}
	
	

	public static Utente buildUtenteInstance(UtenteDTO input) {
		Utente result = new Utente();

		result.setNome(input.getNome());
		result.setCognome(input.getCognome());
		result.setUsername(input.getUsername());
		result.setPassword(input.getPassword());
		result.setCreditoResiduo(input.getCreditoResiduo());
		result.setDataRegistrazione(input.getDataRegistrazione());

		return result;
	}

	public static UtenteDTO buildUtenteDTOInstance(Utente input) {
		UtenteDTO result = new UtenteDTO();

		result.setNome(input.getNome());
		result.setCognome(input.getCognome());
		result.setUsername(input.getUsername());
		result.setPassword(input.getPassword());
		result.setCreditoResiduo(input.getCreditoResiduo());
		result.setDataRegistrazione(input.getDataRegistrazione());

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Double getCreditoResiduo() {
		return creditoResiduo;
	}

	public void setCreditoResiduo(Double creditoResiduo) {
		this.creditoResiduo = creditoResiduo;
	}

	public Date getDataRegistrazione() {
		return dataRegistrazione;
	}

	public void setDataRegistrazione(Date dataRegistrazione) {
		this.dataRegistrazione = dataRegistrazione;
	}

	public Set<Ruolo> getRuoli() {
		return ruoli;
	}

	public void setRuoli(Set<Ruolo> ruoli) {
		this.ruoli = ruoli;
	}

	public Set<Acquisto> getAcquisti() {
		return acquisti;
	}

	public void setAcquisti(Set<Acquisto> acquisti) {
		this.acquisti = acquisti;
	}

	public Set<Annuncio> getAnnunci() {
		return annunci;
	}

	public void setAnnunci(Set<Annuncio> annunci) {
		this.annunci = annunci;
	}

}
