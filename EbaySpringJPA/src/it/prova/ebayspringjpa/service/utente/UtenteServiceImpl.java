package it.prova.ebayspringjpa.service.utente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.prova.ebayspringjpa.dao.utente.UtenteDAO;
import it.prova.ebayspringjpa.model.Utente;


@Component
public class UtenteServiceImpl implements UtenteService {

	@Autowired
	private UtenteDAO utenteDAO;
	
	@Transactional(readOnly = true)
	public List<Utente> listAllUtenti() {
		return utenteDAO.list();
	}

	@Transactional(readOnly = true)
	public Utente caricaSingoloUtente(Long id) {
		return utenteDAO.get(id);
	}

	@Transactional
	public void aggiorna(Utente utenteInstance) {
		utenteDAO.update(utenteInstance);		
	}

	@Transactional
	public void inserisciNuovo(Utente utenteInstance) {
		utenteDAO.insert(utenteInstance);		
	}

	@Transactional
	public void rimuovi(Utente utenteInstance) {
		utenteDAO.delete(utenteInstance);		
	}

	@Transactional(readOnly = true)
	public List<Utente> findByExample(Utente example) {
		return utenteDAO.findByExample(example);
	}

	@Transactional(readOnly = true)
	public Utente eseguiAccesso(String username, String password) {
		return utenteDAO.executeLogin(username, password);
	}

	@Transactional(readOnly = true)
	public Utente caricaEager(Long id) {
		return utenteDAO.getEager(id);
	}

	@Transactional(readOnly = true)
	public Utente eseguiAccessoEager(String username, String password) {
		return utenteDAO.executeLoginEager(username, password);
	}

	@Override
	public Utente getEagerAnnunci(Long id) {
		return utenteDAO.getEagerAnnunci(id);
	}
	


}
