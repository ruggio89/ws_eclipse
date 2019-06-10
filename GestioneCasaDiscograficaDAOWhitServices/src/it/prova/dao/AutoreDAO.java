package it.prova.dao;



import java.util.List;

import id.prova.model.Autore;
import id.prova.model.CasaDiscografica;

public interface AutoreDAO extends IBaseDAO<Autore> {
	
	public void populateCds(Autore input) throws Exception;
	
	public List<Autore> findAllByCasaDiscografica(CasaDiscografica input) throws Exception;
	
	public List<Autore> findBbyCdWhereNTracceGreaterThan(int nTracceInput) throws Exception;
}
