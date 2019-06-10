package it.negozioarticolo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import it.negozioarticolo.model.Articolo;

public class ArticoloDAOImpl implements ArticoloDAO {
	
	private EntityManager entityManager;
	
	@Override
	public List<Articolo> list() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Articolo get(long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Articolo o) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void insert(Articolo o) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Articolo o) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Articolo> findByExample(Articolo o) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;

	}

}
