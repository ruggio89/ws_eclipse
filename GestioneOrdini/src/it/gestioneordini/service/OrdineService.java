package it.gestioneordini.service;

import java.util.List;

import it.gestioneordini.dao.OrdineDAO;
import it.gestioneordini.model.Categoria;
import it.gestioneordini.model.Ordine;

public interface OrdineService {
	
	public List<Ordine> listAll() throws Exception;

	public Ordine caricaSingoloElemento(Long id) throws Exception;

	public void aggiorna(Ordine utenteInstance) throws Exception;

	public void inserisciNuovo(Ordine ordineInstance) throws Exception;

	public void rimuovi(Ordine ordineInstance) throws Exception;

	public List<Ordine> findByExample(Ordine example) throws Exception;

	//per injection
	public void setOrdineDAO(OrdineDAO ordineDAO);
	
	public List<Ordine> voglioTuttiGliOrdininEffettuatiPerUnaDeterminataCategoria(Categoria input) throws Exception;

}
