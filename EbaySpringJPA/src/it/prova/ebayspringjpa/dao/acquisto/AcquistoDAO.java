package it.prova.ebayspringjpa.dao.acquisto;

import java.util.List;

import javax.persistence.Query;

import it.prova.ebayspringjpa.dao.IBaseDAO;
import it.prova.ebayspringjpa.model.Acquisto;
import it.prova.ebayspringjpa.model.Annuncio;
import it.prova.ebayspringjpa.model.Utente;

public interface AcquistoDAO extends IBaseDAO<Acquisto>{
	
	public List<Acquisto> findByUtente(Utente utente);

	
}
