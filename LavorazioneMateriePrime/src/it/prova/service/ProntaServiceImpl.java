package it.prova.service;

import org.springframework.stereotype.Component;

import it.prova.model.MateriaPrima;
import it.prova.model.StatoMateria;

@Component
public class ProntaServiceImpl implements ProntaService{

	@Override
	public void statoPronta(MateriaPrima input) {
		input.setStato(StatoMateria.PRONTA);
	}
	
}
