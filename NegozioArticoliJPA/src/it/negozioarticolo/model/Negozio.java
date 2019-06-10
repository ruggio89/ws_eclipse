package it.negozioarticolo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "negozio")
public class Negozio {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	@Column(name = "ragionesociale")
	private String ragioneSociale;
	@Column(name = "partitaiva")
	private String partitaIva;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "negozio", orphanRemoval = true)
	private Set<Articolo> articoli = new HashSet<>();
	
	public Negozio() {}

	public Negozio(Long id, String ragioneSociale, String partitaIva, Set<Articolo> articoli) {
		super();
		this.id = id;
		this.ragioneSociale = ragioneSociale;
		this.partitaIva = partitaIva;
		this.articoli = articoli;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	public String getPartitaIva() {
		return partitaIva;
	}

	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}

	public Set<Articolo> getArticoli() {
		return articoli;
	}

	public void setArticoli(Set<Articolo> articoli) {
		this.articoli = articoli;
	}
	
	
	
	
}
