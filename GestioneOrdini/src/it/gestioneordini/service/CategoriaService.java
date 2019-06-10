package it.gestioneordini.service;

import java.util.List;

import it.gestioneordini.dao.CategoriaDAO;
import it.gestioneordini.model.Categoria;
import it.gestioneordini.model.Ordine;

public interface CategoriaService {
	
	public List<Categoria> listAll() throws Exception;

	public Categoria caricaSingoloElemento(Long id) throws Exception;

	public void aggiorna(Categoria categoriaInstance) throws Exception;

	public void inserisciNuovo(Categoria categoriaInstance) throws Exception;

	public void rimuovi(Categoria categoriaInstance) throws Exception;

	public List<Categoria> findByExample(Categoria example) throws Exception;

	//per injection
	public void setCategoriaDAO(CategoriaDAO categoriaDAO);
	
	public List<Categoria> voglioTutteLeCategorieDegliArticoliDiUnDeterminatoOrdine(Ordine input) throws Exception;
}
