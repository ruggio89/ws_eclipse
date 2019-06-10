package it.prova.gestionecontribuentespringjpa.service.cartellaesattoriale;

import java.util.List;

import it.prova.gestionecontribuentespringjpa.model.CartellaEsattoriale;


public interface CartellaEsattorialeService {
	
	public List<CartellaEsattoriale> listAllCartelleEsattoriali();

	public CartellaEsattoriale caricaSingolaCartellaEsattoriale(Long id);

	public void aggiorna(CartellaEsattoriale cartellaEsattorialeInstance);

	public void inserisciNuova(CartellaEsattoriale cartellaEsattorialeInstance);

	public void rimuovi(CartellaEsattoriale cartellaEsattorialeInstance);

	public List<CartellaEsattoriale> findByExample(CartellaEsattoriale example);
}
