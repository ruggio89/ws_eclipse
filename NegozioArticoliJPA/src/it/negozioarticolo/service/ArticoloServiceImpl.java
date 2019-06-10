package it.negozioarticolo.service;

import java.util.List;

import it.negozioarticolo.dao.ArticoloDAO;
import it.negozioarticolo.model.Articolo;

public class ArticoloServiceImpl implements ArticoloService{
	
	private ArticoloDAO articoloDao;

	@Override
	public List<Articolo> listAllArticoli() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Articolo caricaSingoloArticolo(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void aggiorna(Articolo articoloInstance) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inserisciNuovo(Articolo articoloInstance) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rimuovi(Articolo articoloInstance) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Articolo> findByExample(Articolo example) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setArticoloDAO(ArticoloDAO articolooDAO) {
		this.articoloDao = articoloDao;
		
	}

}
