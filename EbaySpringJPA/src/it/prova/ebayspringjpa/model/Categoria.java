package it.prova.ebayspringjpa.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String descrizione;
	@Column(unique = true)
	private String codice;
	@ManyToMany
	@JoinTable(name = "annuncio_categoria", joinColumns = @JoinColumn(name = "categoria_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "annuncio_id", referencedColumnName = "id"))
	private Set<Annuncio> annunci = new HashSet<>(0);

	public Categoria() {
		super();
	}

	public Categoria(String descrizione, String codice, Set<Annuncio> annunci) {
		super();
		this.descrizione = descrizione;
		this.codice = codice;
		this.annunci = annunci;
	}

	public Categoria(Long id, String descrizione, String codice, Set<Annuncio> annunci) {
		super();
		this.id = id;
		this.descrizione = descrizione;
		this.codice = codice;
		this.annunci = annunci;
	}

	public Categoria(String descrizione, String codice) {
		super();
		this.descrizione = descrizione;
		this.codice = codice;
	}

	public Categoria(Long id, String descrizione, String codice) {
		super();
		this.id = id;
		this.descrizione = descrizione;
		this.codice = codice;
	}

	public Categoria(String descrizione) {
		super();
		this.descrizione = descrizione;
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
