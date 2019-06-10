package it.gestioneordini.service;

import java.util.List;

import it.gestioneordini.dao.ArticoloDAO;
import it.gestioneordini.model.Articolo;
import it.gestioneordini.model.Categoria;

public interface ArticoloService {
	
	public List<Articolo> listAll() throws Exception;

	public Articolo caricaSingoloElemento(Long id) throws Exception;

	public void aggiorna(Articolo articoloInstance) throws Exception;

	public void inserisciNuovo(Articolo articoloInstance) throws Exception;

	public void rimuovi(Articolo articoloInstance) throws Exception;

	public List<Articolo> findByExample(Articolo example) throws Exception;

	//per injection
	public void setArticoloDAO(ArticoloDAO articoloDAO);
	
	public int voglioLaSommaTotaleDiTuttiIPrezziDegliArticoliLegatiAdUnaCategoria(Categoria input) throws Exception;
}
