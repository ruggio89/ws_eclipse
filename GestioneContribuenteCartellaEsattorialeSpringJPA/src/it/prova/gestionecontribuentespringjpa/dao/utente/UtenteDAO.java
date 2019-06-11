package it.prova.gestionecontribuentespringjpa.dao.utente;

import it.prova.gestionecontribuentespringjpa.dao.IBaseDAO;
import it.prova.gestionecontribuentespringjpa.model.Utente;

public interface UtenteDAO extends IBaseDAO<Utente>{

	public Utente executeLogin(String username,String password);
	
	public Utente getEager(Long id);
	
	public Utente executeLoginEager(String username, String password);
}
