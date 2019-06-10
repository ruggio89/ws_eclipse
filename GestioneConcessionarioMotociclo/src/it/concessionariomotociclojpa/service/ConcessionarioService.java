package it.concessionariomotociclojpa.service;

import java.util.List;

import it.concessionariomotociclojpa.model.Concessionario;

public interface ConcessionarioService {
	public List<Concessionario> listAllConcessionari();

	public Concessionario caricaSingoloConcessionario(Long id);

	public void aggiorna(Concessionario concessionarioInstance);

	public void inserisciNuovo(Concessionario concessionarioInstance);

	public void rimuovi(Concessionario concessionarioInstance);

	public List<Concessionario> findByExample(Concessionario example);

	public void refresh(Concessionario concessionarioInstance);

	public List<Concessionario> trovaMotocicloCilindrataMaggiore1200PerDenominazione();

	public List<Concessionario> listPartitaIvaAMilanoPerHondaTra2012E2016();

}
