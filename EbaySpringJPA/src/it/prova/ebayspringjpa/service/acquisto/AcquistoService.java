package it.prova.ebayspringjpa.service.acquisto;

import java.util.List;

import it.prova.ebayspringjpa.model.Acquisto;
import it.prova.ebayspringjpa.model.Utente;

public interface AcquistoService {

	public List<Acquisto> listAllAcquisti() ;

	public Acquisto caricaSingoloAcquisto(Long id);

	public void aggiorna(Acquisto acquistoInstance);

	public void inserisciNuovo(Acquisto acquistoInstance);

	public void rimuovi(Acquisto acquistoInstance);

	public List<Acquisto> findByExample(Acquisto example);
	
	public List<Acquisto> findByUtente(Utente utente);
	
	public void acquista(Long idAnnuncio, Long idUtente);
}
