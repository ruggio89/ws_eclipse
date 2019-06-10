package it.negozioarticolo.service;

import java.util.List;

import javax.persistence.EntityManager;

import it.negozioarticolo.dao.EntityManagerUtil;
import it.negozioarticolo.dao.NegozioDAO;
import it.negozioarticolo.model.Negozio;

public class NegozioServiceImpl implements NegozioService {

	private NegozioDAO negozioDAO;

	@Override
	public List<Negozio> listAllNegozi() throws Exception {

		try {
			// uso l'injection per il dao
			negozioDAO.setEntityManager(EntityManagerUtil.getEntityManager());

			// eseguo quello che realmente devo fare
			return negozioDAO.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public Negozio caricaSingoloNegozio(Long id) throws Exception {
		try {
			// uso l'injection per il dao
			negozioDAO.setEntityManager(EntityManagerUtil.getEntityManager());

			// eseguo quello che realmente devo fare
			return negozioDAO.get(id);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void aggiorna(Negozio negozioInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			negozioDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			negozioDAO.update(negozioInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}

	}

	@Override
	public void inserisciNuovo(Negozio negozioInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			negozioDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			negozioDAO.insert(negozioInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}

	}

	@Override
	public void rimuovi(Negozio negozioInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			negozioDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			negozioDAO.delete(negozioInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}

	}

	@Override
	public List<Negozio> findByExample(Negozio example) throws Exception {
		try {
			// uso l'injection per il dao
			negozioDAO.setEntityManager(EntityManagerUtil.getEntityManager());

			// eseguo quello che realmente devo fare
			return negozioDAO.findByExample(example);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void setNegozioDAO(NegozioDAO negozioDAO) {
		this.negozioDAO = negozioDAO;
	}

}
