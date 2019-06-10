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
	private String ragionesociale;
	@Column(name = "piva")
	private String piva;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "negozio", orphanRemoval = true)
	private Set<Articolo> articoli = new HashSet<>();

	@Override
	public String toString() {
		return "Negozio [id=" + id + ", ragionesociale=" + ragionesociale + ", piva=" + piva + "]";
	}

	public Negozio(String ragionesociale, String piva) {
		super();
		this.ragionesociale = ragionesociale;
		this.piva = piva;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRagionesociale() {
		return ragionesociale;
	}

	public void setRagionesociale(String ragionesociale) {
		this.ragionesociale = ragionesociale;
	}

	public String getPiva() {
		return piva;
	}

	public void setPiva(String piva) {
		this.piva = piva;
	}

	public Set<Articolo> getArticoli() {
		return articoli;
	}

	public void setArticoli(Set<Articolo> articoli) {
		this.articoli = articoli;
	}

	public Negozio() {
	}
}
