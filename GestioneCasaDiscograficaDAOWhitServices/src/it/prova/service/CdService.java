package it.prova.service;

import java.util.List;

import id.prova.model.Autore;
import id.prova.model.Cd;
import it.prova.dao.CdDAO;

public interface CdService {
	public void setCdDAO(CdDAO cdDao);

	public List<Cd> listAllCd() throws Exception;

	public Cd findCdById(Long idInput) throws Exception;

	public int aggiornaCd(Cd input) throws Exception;

	public int inserisciNuovoCd(Cd input) throws Exception;

	public int rimuoviCd(Cd input) throws Exception;

	public List<Cd> findByExample(Cd input) throws Exception;
	
	public List<Cd> trovaCdDaGenere(String genere) throws Exception;
	
	public List<Cd> trovaTuttiICdDaAutoreDoveTitoloIniziaCon(Autore autoreInput, String iniziale) throws Exception;
}
