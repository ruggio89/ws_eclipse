package it.prova.service;

import org.springframework.stereotype.Component;

import it.prova.model.MateriaPrima;
import it.prova.model.StatoMateria;

@Component
public class MessaInOperaServiceImpl implements MessaInOperaService {

	@Override
	public void statoMessaInOpera(MateriaPrima input) {
		input.setStato(StatoMateria.IN_MESSA_IN_OPERA);
		System.out.println(input);
		
	}

}
