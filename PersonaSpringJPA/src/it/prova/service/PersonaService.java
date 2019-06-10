package it.prova.service;

import java.util.List;

import it.prova.model.Persona;

public interface PersonaService {
	
	public List<Persona> listPersone();
	
	public List<Persona> cercaPersonaByExample(Persona example);
	
	public Persona caricaSingolaPersona(long idPersonaInput);
	
	public void aggiorna(Persona personaInstance);

	public void inserisciNuovo(Persona personaInstance);

	public void rimuovi(Persona personaInstance);

	public List<Persona> findByExample(Persona example);


}
