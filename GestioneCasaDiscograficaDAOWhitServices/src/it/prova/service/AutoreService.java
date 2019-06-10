package it.prova.service;

import java.util.List;

import id.prova.model.Autore;
import id.prova.model.CasaDiscografica;
import id.prova.model.Cd;
import it.prova.dao.AutoreDAO;

public interface AutoreService {
	// questo mi serve per injection
			public void setAutoreDao(AutoreDAO autoreDao);

			public List<Autore> listAllAutore() throws Exception;

			public Autore findAutoreById(Long idInput) throws Exception;

			public int aggiornaAutore(Autore input) throws Exception;

			public int inserisciNuovaAutore(Autore input) throws Exception;

			public int rimuoviAutore(Autore input) throws Exception;

			public List<Autore> findByExample(Autore input) throws Exception;
			
			public void aggiungiCdAdAutore(Autore input) throws Exception;
			
			public List<Autore> trovaAutoriDaCasaDiscografica(CasaDiscografica input) throws Exception;
			
			public List<Autore> trovaAutoreDaCdConNumeroDiTracceMaggioreDi(int nTracceInput) throws Exception;
}
