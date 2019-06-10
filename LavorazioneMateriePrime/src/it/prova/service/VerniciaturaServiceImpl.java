package it.prova.service;

import org.springframework.stereotype.Component;

import it.prova.model.MateriaPrima;
import it.prova.model.StatoMateria;

@Component
public class VerniciaturaServiceImpl implements VerniciaturaService{

	@Override
	public void statoInVerniciatura(MateriaPrima input) {
		input.setStato(StatoMateria.IN_VERNICIATURA);
		
	}

}
