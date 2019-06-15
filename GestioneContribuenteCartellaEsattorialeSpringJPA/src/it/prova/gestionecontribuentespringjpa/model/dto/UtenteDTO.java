package it.prova.gestionecontribuentespringjpa.model.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.prova.gestionecontribuentespringjpa.model.Contribuente;
import it.prova.gestionecontribuentespringjpa.model.Ruolo;
import it.prova.gestionecontribuentespringjpa.model.Utente;

public class UtenteDTO {

	private Long id;
	private String nome;
	private String cognome;
	private String username;
	private String password;
	private Date dataRegistrazione;
	private Set<Ruolo> ruoli = new HashSet<>(0);

	public UtenteDTO() {
		super();
	}

	public UtenteDTO(String nome, String cognome, String username, String password, Date dataRegistrazione) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
		this.dataRegistrazione = dataRegistrazione;
	}

	public UtenteDTO(String nome, String cognome, String username) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
	}

	public UtenteDTO(String nome, String cognome, String username, String password) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
	}

	public UtenteDTO(Long id, String nome, String cognome, String username, String password, Date dataRegistrazione,
			Set<Ruolo> ruoli) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
		this.dataRegistrazione = dataRegistrazione;
		this.ruoli = ruoli;
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
	
	@SuppressWarnings("unlikely-arg-type")
	public List<String> validate() {
		List<String> listaErrori = new ArrayList<String>();

		if (nome.equals("") || nome == null) {
			listaErrori.add("Inserire correttamente campo nome");
		}
		if (cognome.equals("") || cognome == null) {
			listaErrori.add("Inserire correttamente campo cognome");
		}
		if (username.equals("") || username == null) {
			listaErrori.add("Inserire correttamente campo codice fiscale");
		}
		if (password.equals("") || password == null) {
			listaErrori.add("Inserire correttamente campo indirizzo");
		}
		if (dataRegistrazione.equals("") || dataRegistrazione == null) {
			listaErrori.add("Inserire correttamente campo indirizzo");
		}
		return listaErrori;
	}
	
	public static Utente buildUtenteInstance(UtenteDTO input) {
		Utente result = new Utente();

		result.setNome(input.getNome());
		result.setCognome(input.getCognome());
		result.setUsername(input.getUsername());
		result.setPassword(input.getPassword());
		result.setDataRegistrazione(input.getDataRegistrazione() );

		return result;
	}
	

}
