package it.prova.service;

import org.springframework.stereotype.Component;

import it.prova.model.MateriaPrima;
import it.prova.model.StatoMateria;

@Component
public class LavorazioneServiceImpl implements LavorazioneService{

	@Override
	public void statoLavorazione(MateriaPrima input) {
		input.setStato(StatoMateria.IN_LAVORAZIONE);
		
	}

}
