package it.prova.service;

import org.springframework.stereotype.Component;

import it.prova.model.Studente;

@Component
public class ProfessoreScienzeServiceImpl implements ProfessoreScienzeService{

	@Override
	public void esaminaInScienze(Studente studente) {
		System.out.println("Interrogazione di scienze allo studente "+studente+ " effettuate...");
		
	}

}
