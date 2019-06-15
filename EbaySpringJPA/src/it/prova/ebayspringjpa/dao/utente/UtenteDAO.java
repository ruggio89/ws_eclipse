package it.prova.ebayspringjpa.dao.utente;

import it.prova.ebayspringjpa.dao.IBaseDAO;
import it.prova.ebayspringjpa.model.Utente;

public interface UtenteDAO extends IBaseDAO<Utente>{
	
	public Utente executeLogin(String username,String password);
	
	public Utente getEager(Long id);
	
	public Utente executeLoginEager(String username, String password);
	
	public Utente getEagerAnnunci(Long id);
}
