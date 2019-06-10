package it.prova.gestionecontribuentespringjpa.service.contribuente;

import java.util.List;

import it.prova.gestionecontribuentespringjpa.model.Contribuente;


public interface ContribuenteService {

	
	public List<Contribuente> listAllContribuenti() ;

	public Contribuente caricaSingoloContribuente(Long id);

	public void aggiorna(Contribuente contribuenteInstance);

	public void inserisciNuovo(Contribuente contribuenteInstance);

	public void rimuovi(Contribuente contribuenteInstance);

	public List<Contribuente> findByExample(Contribuente example);
}
