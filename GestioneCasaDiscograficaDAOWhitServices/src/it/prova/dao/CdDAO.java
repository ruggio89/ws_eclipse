package it.prova.dao;

import java.util.List;

import id.prova.model.Autore;
import id.prova.model.Cd;

public interface CdDAO extends IBaseDAO<Cd>{
	
	public List<Cd> findAllByGenere(String genere) throws Exception;
	
	public List<Cd> findAllByAutoreWhereTitoloIniziaCon(Autore autoreInput, String iniziale) throws Exception;
}
