package it.prova.service;

import org.springframework.stereotype.Component;

import it.prova.model.MateriaPrima;
import it.prova.model.StatoMateria;

@Component
public class AssemblaggioServiceImpl implements AssemblaggioService{

	@Override
	public void statoInAssemblaggio(MateriaPrima input) {
		input.setStato(StatoMateria.IN_ASSEMBLAGGIO);
		
	}

}
