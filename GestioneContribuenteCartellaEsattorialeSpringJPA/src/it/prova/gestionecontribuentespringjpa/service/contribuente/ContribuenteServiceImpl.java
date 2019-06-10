package it.prova.gestionecontribuentespringjpa.service.contribuente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.prova.gestionecontribuentespringjpa.dao.contribuente.ContribuenteDAO;
import it.prova.gestionecontribuentespringjpa.model.Contribuente;

@Component
public class ContribuenteServiceImpl implements ContribuenteService{

	@Autowired
	private ContribuenteDAO contribuenteDAO;
	
	@Transactional(readOnly = true)
	public List<Contribuente> listAllContribuenti() {
		return contribuenteDAO.list();
	}

	@Transactional(readOnly = true)
	public Contribuente caricaSingoloContribuente(Long id) {
		return contribuenteDAO.get(id);
	}

	@Transactional
	public void aggiorna(Contribuente contribuenteInstance) {
		contribuenteDAO.update(contribuenteInstance);		
	}

	@Transactional
	public void inserisciNuovo(Contribuente contribuenteInstance) {
		contribuenteDAO.insert(contribuenteInstance);		
	}

	@Transactional
	public void rimuovi(Contribuente contribuenteInstance) {
		contribuenteDAO.delete(contribuenteInstance);		
	}

	@Transactional(readOnly = true)
	public List<Contribuente> findByExample(Contribuente example) {
		return contribuenteDAO.findByExample(example);
	}

}
