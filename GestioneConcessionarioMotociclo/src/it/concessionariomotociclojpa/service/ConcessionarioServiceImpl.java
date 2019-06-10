package it.concessionariomotociclojpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.concessionariomotociclojpa.dao.ConcessionarioDAO;
import it.concessionariomotociclojpa.model.Concessionario;

@Component
public class ConcessionarioServiceImpl implements ConcessionarioService {

	@Autowired
	private ConcessionarioDAO concessionarioDAO;

	@Transactional(readOnly = true)
	public List<Concessionario> listAllConcessionari() {
		return concessionarioDAO.list();
	}

	@Transactional(readOnly = true)
	public Concessionario caricaSingoloConcessionario(Long id) {
		return concessionarioDAO.get(id);
	}

	@Transactional
	public void aggiorna(Concessionario concessionarioInstance) {
		concessionarioDAO.update(concessionarioInstance);
	}

	@Transactional
	public void inserisciNuovo(Concessionario concessionarioInstance) {
		concessionarioDAO.insert(concessionarioInstance);
	}

	@Transactional
	public void rimuovi(Concessionario concessionarioInstance) {
		concessionarioDAO.delete(concessionarioInstance);
	}

	@Transactional(readOnly = true)
	public List<Concessionario> findByExample(Concessionario example) {
		return concessionarioDAO.findByExample(example);
	}

	@Transactional(readOnly = true)
	public void refresh(Concessionario concessionarioInstance) {
		concessionarioDAO.refresh(concessionarioInstance);
	}

	@Transactional(readOnly = true)
	public List<Concessionario> trovaMotocicloCilindrataMaggiore1200PerDenominazione() {
		return concessionarioDAO.findMotocicloCilindrataMaggiore1200PerDenominazione();
	}

	@Override
	public List<Concessionario> listPartitaIvaAMilanoPerHondaTra2012E2016() {
		return concessionarioDAO.listPartitaIvaAMilanoPerHondaTra2012E2016();

	}

}
