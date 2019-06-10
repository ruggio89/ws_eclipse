package it.negozioarticolo.service;

import java.util.List;

import it.negozioarticolo.dao.ArticoloDAO;
import it.negozioarticolo.model.Articolo;



public interface ArticoloService {

	public List<Articolo> listAllArticolo() throws Exception;

	public Articolo caricaSingoloArticolo(Long id) throws Exception;
	
	public void aggiorna(Articolo negozioInstance) throws Exception;

	public void inserisciNuovo(Articolo negozioInstance) throws Exception;

	public void rimuovi(Articolo negozioInstance) throws Exception;

	public List<Articolo> findByExample(Articolo example) throws Exception;

	//per injection
	public void setArticoloDAO(ArticoloDAO articoloDAO);
}
