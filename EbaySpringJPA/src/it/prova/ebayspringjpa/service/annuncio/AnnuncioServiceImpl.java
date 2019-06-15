package it.prova.ebayspringjpa.service.annuncio;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.prova.ebayspringjpa.dao.acquisto.AcquistoDAO;
import it.prova.ebayspringjpa.dao.annuncio.AnnuncioDAO;
import it.prova.ebayspringjpa.dao.utente.UtenteDAO;
import it.prova.ebayspringjpa.model.Annuncio;
import it.prova.ebayspringjpa.model.Categoria;
import it.prova.ebayspringjpa.model.Utente;

@Component
public class AnnuncioServiceImpl implements AnnuncioService {

	@Autowired
	private AnnuncioDAO annuncioDAO;
	
	@Transactional(readOnly = true)
	public List<Annuncio> listAllAnnunci() {
		return annuncioDAO.list();
	}

	@Transactional(readOnly = true)
	public Annuncio caricaSingoloAnnuncio(Long id) {
		return annuncioDAO.get(id);
	}

	@Transactional
	public void aggiorna(Annuncio annuncioInstance) {
		annuncioDAO.update(annuncioInstance);
	}

	@Transactional
	public void inserisciNuovo(Annuncio annuncioInstance) {
		annuncioDAO.insert(annuncioInstance);
	}

	@Transactional
	public void rimuovi(Annuncio annuncioInstance) {
		annuncioDAO.delete(annuncioInstance);

	}

	@Transactional(readOnly = true)
	public List<Annuncio> findByExample(Annuncio example) {
		return annuncioDAO.findByExample(example);

	}

	@Transactional(readOnly = true)
	public List<Annuncio> findByNomeECategoria(String testo, Set<Categoria> categorie) {
		return annuncioDAO.findByNomeECategoria(testo, categorie);
	}

	@Transactional(readOnly = true)
	public List<Annuncio> findByNomeCategoriaEPrezzo(String testo, Set<Categoria> categorie, double prezzo) {
		return annuncioDAO.findByNomeCategoriaEPrezzo(testo, categorie, prezzo);
	}

	@Transactional(readOnly = true)
	public Annuncio getEagerCategorie(Long id) {
		return annuncioDAO.getEagerCategorie(id);
	}

	@Transactional
	public Annuncio getEagerCategorieEUtente(Long id) {
		return annuncioDAO.getEagerCategorieEUtente(id);

	}

	@Transactional(readOnly = true)
	public List<Annuncio> listEagerCategorie() {
		return annuncioDAO.listEagerCategorie();
	}

	@Transactional(readOnly = true)
	public List<Annuncio> findByUtenteECategoria(Utente utente) {
		return annuncioDAO.findByUtenteECategoria(utente);
	}

	@Override
	public List<Annuncio> findByCategoria(Utente utente) {
		return annuncioDAO.findByCategoria(utente);
	}

}
