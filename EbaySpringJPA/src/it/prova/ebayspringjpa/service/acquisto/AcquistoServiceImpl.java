package it.prova.ebayspringjpa.service.acquisto;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.prova.ebayspringjpa.dao.acquisto.AcquistoDAO;
import it.prova.ebayspringjpa.dao.annuncio.AnnuncioDAO;
import it.prova.ebayspringjpa.dao.utente.UtenteDAO;
import it.prova.ebayspringjpa.model.Acquisto;
import it.prova.ebayspringjpa.model.Annuncio;
import it.prova.ebayspringjpa.model.Utente;

@Component
public class AcquistoServiceImpl implements AcquistoService {

	@Autowired
	private AcquistoDAO acquistoDAO;

	@Autowired
	private AnnuncioDAO annuncioDAO;

	@Autowired
	private UtenteDAO utenteDAO;

	@Transactional(readOnly = true)
	public List<Acquisto> listAllAcquisti() {
		return acquistoDAO.list();
	}

	@Transactional(readOnly = true)
	public Acquisto caricaSingoloAcquisto(Long id) {
		return acquistoDAO.get(id);
	}

	@Transactional
	public void aggiorna(Acquisto acquistoInstance) {
		acquistoDAO.update(acquistoInstance);
	}

	@Transactional
	public void inserisciNuovo(Acquisto acquistoInstance) {
		acquistoDAO.insert(acquistoInstance);
	}

	@Transactional
	public void rimuovi(Acquisto acquistoInstance) {
		acquistoDAO.delete(acquistoInstance);
	}

	@Transactional(readOnly = true)
	public List<Acquisto> findByExample(Acquisto example) {
		return acquistoDAO.findByExample(example);
	}

	@Transactional(readOnly = true)
	public List<Acquisto> findByUtente(Utente utente) {
		return acquistoDAO.findByUtente(utente);
	}

	@Transactional
	public void acquista(Long idAnnuncio, Long idUtente) {

		Date data = new Date();
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);

		Utente utenteCheAcquista = utenteDAO.getEager(idUtente);
		Annuncio annuncioDaAcquistare = annuncioDAO.getEagerCategorieEUtente(idAnnuncio);

		annuncioDaAcquistare.setApertoChiuso(false);
		Double prezzo = annuncioDaAcquistare.getPrezzo();
		utenteCheAcquista.setCreditoResiduo(utenteCheAcquista.getCreditoResiduo() - prezzo);

		Acquisto acquisto = new Acquisto();
		acquisto.setAnno(year);
		acquisto.setDescrizione(annuncioDaAcquistare.getTestoAnnuncio());
		acquisto.setPrezzo(annuncioDaAcquistare.getPrezzo());
		acquisto.setUtente(utenteCheAcquista);
		acquistoDAO.insert(acquisto);

		utenteCheAcquista.getAcquisti().add(acquisto);
		annuncioDAO.update(annuncioDaAcquistare);
		utenteDAO.update(utenteCheAcquista);

	}

}
