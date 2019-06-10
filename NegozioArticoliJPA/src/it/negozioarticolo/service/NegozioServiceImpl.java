package it.negozioarticolo.service;

import java.util.List;

import it.negozioarticolo.dao.EntityManagerUtil;
import it.negozioarticolo.dao.NegozioDAO;
import it.negozioarticolo.model.Negozio;

public class NegozioServiceImpl implements NegozioService{
	
	private NegozioDAO negozioDao;

	@Override
	public List<Negozio> listAllNegozi() throws Exception {
		try {
			// uso l'injection per il dao
			negozioDao.setEntityManager(EntityManagerUtil.getEntityManager());

			// eseguo quello che realmente devo fare
			return negozioDao.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public Negozio caricaSingoloNegozio(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void aggiorna(Negozio negozioInstance) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inserisciNuovo(Negozio negozioInstance) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rimuovi(Negozio negozioInstance) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Negozio> findByExample(Negozio example) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setNegozioDAO(NegozioDAO negozioDAO) {
		this.negozioDao = negozioDao;
		
	}

}
