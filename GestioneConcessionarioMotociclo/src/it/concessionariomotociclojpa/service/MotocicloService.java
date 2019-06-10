package it.concessionariomotociclojpa.service;

import java.util.List;

import it.concessionariomotociclojpa.model.Motociclo;

public interface MotocicloService {
	public List<Motociclo> listAllMotocicli();

	public Motociclo caricaSingoloMotociclo(Long id);

	public void aggiorna(Motociclo motocicloInstance);

	public void inserisciNuovo(Motociclo motocicloInstance);

	public void rimuovi(Motociclo motocicloInstance);

	public List<Motociclo> findByExample(Motociclo example);

	public void refresh(Motociclo motocicloInstance);

	public Long numeroMotocicliImmatricolazioneMinore2010InTorino();

}
