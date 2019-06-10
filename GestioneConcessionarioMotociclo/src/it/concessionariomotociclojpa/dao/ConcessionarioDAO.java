package it.concessionariomotociclojpa.dao;

import java.util.List;

import it.concessionariomotociclojpa.model.Concessionario;

public interface ConcessionarioDAO extends IBaseDAO<Concessionario> {
	public List<Concessionario> findMotocicloCilindrataMaggiore1200PerDenominazione();

	public List<Concessionario> listPartitaIvaAMilanoPerHondaTra2012E2016();
}
