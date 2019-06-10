package it.prova.gestionemunicipiospringjpa.model;

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
public class Municipio {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String descrizione;
	private String codice;
	private String ubicazione;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, mappedBy = "municipio", orphanRemoval = true)
	private Set<Abitante> abitanti = new HashSet<>();

	public Municipio() {
	}

	public Municipio(String descrizione, String codice, String ubicazione) {
		super();
		this.descrizione = descrizione;
		this.codice = codice;
		this.ubicazione = ubicazione;
	}
	
	
	
	

	public Municipio(Long id) {
		super();
		this.id = id;
	}

	public Municipio(Long id, String descrizione, String codice, String ubicazione, Set<Abitante> abitanti) {
		super();
		this.id = id;
		this.descrizione = descrizione;
		this.codice = codice;
		this.ubicazione = ubicazione;
		this.abitanti = abitanti;
	}
	
	

	public Municipio(Long id, String descrizione, String codice, String ubicazione) {
		super();
		this.id = id;
		this.descrizione = descrizione;
		this.codice = codice;
		this.ubicazione = ubicazione;
	}

	public Municipio(String descrizione, String codice, String ubicazione, Set<Abitante> abitanti) {
		super();
		this.descrizione = descrizione;
		this.codice = codice;
		this.ubicazione = ubicazione;
		this.abitanti = abitanti;
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
