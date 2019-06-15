package it.prova.ebayspringjpa.dao.annuncio;

import java.util.List;
import java.util.Set;

import it.prova.ebayspringjpa.dao.IBaseDAO;
import it.prova.ebayspringjpa.model.Annuncio;
import it.prova.ebayspringjpa.model.Categoria;
import it.prova.ebayspringjpa.model.Utente;

public interface AnnuncioDAO extends IBaseDAO<Annuncio> {

	public List<Annuncio> findByNomeECategoria(String testo, Set<Categoria> categorie);
	
	public List<Annuncio> findByNomeCategoriaEPrezzo(String testo, Set<Categoria> categorie, double prezzo);
	
	public Annuncio getEagerCategorie(Long id);
	
	public Annuncio getEagerCategorieEUtente(Long id);
	
	public List<Annuncio> listEagerCategorie();

	public List<Annuncio> findByUtenteECategoria(Utente utente);
	
	public List<Annuncio> findByCategoria(Utente utente);
}
