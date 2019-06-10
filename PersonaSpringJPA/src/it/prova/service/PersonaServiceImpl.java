package it.prova.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.prova.dao.PersonaDAO;
import it.prova.model.Persona;

@Component
public class PersonaServiceImpl implements PersonaService {

	@Autowired
	private PersonaDAO personaDAO;

	@Transactional(readOnly = true)
	public List<Persona> cercaPersonaByExample(Persona example) {
		return personaDAO.findByExample(example);
	}

	@Transactional(readOnly = true)
	public Persona caricaSingolaPersona(long idPersonaInput) {
		return personaDAO.get(idPersonaInput);
	}

	@Transactional
	public void aggiorna(Persona personaInstance) {
		personaDAO.update(personaInstance);
	}

	@Transactional
	public void inserisciNuovo(Persona personaInstance) {
		personaDAO.insert(personaInstance);
	}

	@Transactional
	public void rimuovi(Persona personaInstance) {
		personaDAO.delete(personaInstance);
	}

	@Transactional(readOnly = true)
	public List<Persona> findByExample(Persona example) {
		return personaDAO.findByExample(example);
	}

	@Transactional(readOnly = true)
	public List<Persona> listPersone() {
		return personaDAO.list();
	}

}
