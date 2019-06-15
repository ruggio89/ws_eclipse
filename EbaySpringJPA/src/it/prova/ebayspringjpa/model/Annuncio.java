package it.prova.ebayspringjpa.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "annuncio")

public class Annuncio {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private boolean apertoChiuso;
	private String testoAnnuncio;
	@Temporal(TemporalType.DATE)
	private Date dataAnnuncio;
	private double prezzo;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "utente_id", nullable = false)
	private Utente utente;
	@ManyToMany
	@JoinTable(name = "annuncio_categoria", joinColumns = @JoinColumn(name = "annuncio_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "categoria_id", referencedColumnName = "id"))
	private Set<Categoria> categorie = new HashSet<>(0);

	public Annuncio() {
		super();
	}
	
	

	public Annuncio(String testoAnnuncio) {
		super();
		this.testoAnnuncio = testoAnnuncio;
	}



	public Annuncio(boolean apertoChiuso, String testoAnnuncio, Date dataAnnuncio, double prezzo) {
		super();
		this.apertoChiuso = apertoChiuso;
		this.testoAnnuncio = testoAnnuncio;
		this.dataAnnuncio = dataAnnuncio;
		this.prezzo = prezzo;
	}

	public Annuncio(boolean apertoChiuso, String testoAnnuncio, Date dataAnnuncio, double prezzo, Utente utente,
			Set<Categoria> categorie) {
		super();
		this.apertoChiuso = apertoChiuso;
		this.testoAnnuncio = testoAnnuncio;
		this.dataAnnuncio = dataAnnuncio;
		this.prezzo = prezzo;
		this.utente = utente;
		this.categorie = categorie;
	}

	public Annuncio(Long id, boolean apertoChiuso, String testoAnnuncio, Date dataAnnuncio, double prezzo,
			Utente utente, Set<Categoria> categorie) {
		super();
		this.id = id;
		this.apertoChiuso = apertoChiuso;
		this.testoAnnuncio = testoAnnuncio;
		this.dataAnnuncio = dataAnnuncio;
		this.prezzo = prezzo;
		this.utente = utente;
		this.categorie = categorie;
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

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}


	public Set<Categoria> getCategorie() {
		return categorie;
	}

	public void setCategorie(Set<Categoria> categorie) {
		this.categorie = categorie;
	}

}
