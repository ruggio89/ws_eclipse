package it.gestioneordini.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categoria")
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String descrizione;

	@ManyToMany(mappedBy = "categorie")
	private Set<Articolo> articoli = new HashSet<>(0);

	public Categoria() {

	}

	public Categoria(String descrizione) {
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

	public Set<Articolo> getArticoli() {
		return articoli;
	}

	public void setArticoli(Set<Articolo> articoli) {
		this.articoli = articoli;
	}
	
	public void aggiungiArticolo(Articolo articolo) {
		this.articoli.add(articolo);
		articolo.getCategorie().add(this);
	}
	
	public void rimuoviArticolo(Articolo articolo) {
		this.articoli.remove(articolo);
		articolo.getCategorie().add(this);
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", descrizione=" + descrizione + ", articoli=" + articoli + "]";
	}
	
	

}
