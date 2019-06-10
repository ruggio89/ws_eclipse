package it.concessionariomotociclojpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.concessionariomotociclojpa.dao.MotocicloDAO;
import it.concessionariomotociclojpa.model.Motociclo;

@Component
public class MotocicloServiceImpl implements MotocicloService {

	@Autowired
	private MotocicloDAO motocicloDAO;

	@Transactional(readOnly = true)
	public List<Motociclo> listAllMotocicli() {
		return motocicloDAO.list();
	}

	@Transactional(readOnly = true)
	public Motociclo caricaSingoloMotociclo(Long id) {
		return motocicloDAO.get(id);
	}

	@Transactional
	public void aggiorna(Motociclo motocicloInstance) {
		motocicloDAO.update(motocicloInstance);
	}

	@Transactional
	public void inserisciNuovo(Motociclo motocicloInstance) {
		motocicloDAO.insert(motocicloInstance);
	}

	@Transactional
	public void rimuovi(Motociclo motocicloInstance) {
		motocicloDAO.delete(motocicloInstance);
	}

	@Transactional(readOnly = true)
	public List<Motociclo> findByExample(Motociclo example) {
		return motocicloDAO.findByExample(example);
	}

	@Transactional(readOnly = true)
	public void refresh(Motociclo motocicloInstance) {
		motocicloDAO.refresh(motocicloInstance);
	}

	@Transactional(readOnly = true)
	public Long numeroMotocicliImmatricolazioneMinore2010InTorino() {
		return motocicloDAO.numeroMotocicliImmatricolazioneMinore2010InTorino();
	}

}
