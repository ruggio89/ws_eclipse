package it.negozioarticolo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import it.negozioarticolo.model.Negozio;

public class NegozioDAOImpl implements NegozioDAO {

	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Negozio> list() throws Exception {
		return entityManager.createQuery("from Negozio").getResultList();
	}

	@Override
	public Negozio get(long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Negozio o) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(Negozio o) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Negozio o) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Negozio> findByExample(Negozio o) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
		
	}

}
