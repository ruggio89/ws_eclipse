package it.prova.ebayspringjpa.service.utente;

import java.util.List;

import javax.persistence.Query;

import it.prova.ebayspringjpa.model.Utente;


public interface UtenteService {
	
	public List<Utente> listAllUtenti() ;

	public Utente caricaSingoloUtente(Long id);

	public void aggiorna(Utente utenteInstance);

	public void inserisciNuovo(Utente utenteInstance);

	public void rimuovi(Utente utenteInstance);

	public List<Utente> findByExample(Utente example);
	
	public Utente eseguiAccesso(String username, String password);
	
	public Utente caricaEager(Long id);
	
	public Utente eseguiAccessoEager(String username, String password);
	
	public Utente getEagerAnnunci(Long id);
}
