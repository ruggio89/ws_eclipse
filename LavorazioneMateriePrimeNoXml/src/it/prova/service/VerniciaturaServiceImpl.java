package it.prova.service;

import org.springframework.stereotype.Component;

import it.prova.model.MateriaPrima;
import it.prova.model.StatoMateria;

@Component
public class VerniciaturaServiceImpl implements VerniciaturaService {
	@Override
	public void statoVerniciatura(MateriaPrima input) {
		input.setStato(StatoMateria.IN_VERNICIATURA);
		System.out.println(input);
	}
}
