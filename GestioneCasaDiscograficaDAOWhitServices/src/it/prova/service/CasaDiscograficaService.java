package it.prova.service;

import java.util.List;

import id.prova.model.Autore;
import id.prova.model.CasaDiscografica;
import it.prova.dao.CasaDiscograficaDAO;

public interface CasaDiscograficaService {
	// questo mi serve per injection
		public void setCasaDiscograficaDao(CasaDiscograficaDAO casaDiscograficaDao);

		public List<CasaDiscografica> listAllCasaDiscografica() throws Exception;

		public CasaDiscografica findCasaDiscograficaById(Long idInput) throws Exception;

		public int aggiornaCasaDiscografica(CasaDiscografica input) throws Exception;

		public int inserisciNuovaCasaDiscografica(CasaDiscografica input) throws Exception;

		public int rimuoviCasaDiscografica(CasaDiscografica input) throws Exception;

		public List<CasaDiscografica> findByExample(CasaDiscografica input) throws Exception;
		
		public void aggiungiAutoreACasaDiscografica(CasaDiscografica input) throws Exception;
		
		public List<CasaDiscografica> trovaAutoreInCaseDiscografiche(Autore input) throws Exception;
		
		public List<CasaDiscografica> trovaAutoreConCognomeCheIniziaPer(String iniziale) throws Exception;
		
		public List <CasaDiscografica> trovaTuttiICdPerGenere(String genere) throws Exception;
		
		public int aggiornaDueVolte(CasaDiscografica input, CasaDiscografica input2) throws Exception;
}
