package it.prova.service;

import java.util.List;

import it.prova.model.Vino;

public interface VinoService {
	
	public List<Vino> listVini();
	
	public List<Vino> cercaVinoByExample(Vino example);
	
	public Vino caricaSingoloVino(long idVinoInput);
	
	public void aggiorna(Vino vinoInstance);

	public void inserisciNuovo(Vino vinoInstance);

	public void rimuovi(Vino vinoInstance);
}
