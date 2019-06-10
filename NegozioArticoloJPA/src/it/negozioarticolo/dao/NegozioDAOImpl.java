package it.negozioarticolo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;

import it.negozioarticolo.model.Negozio;

public class NegozioDAOImpl implements NegozioDAO {

	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Negozio> list() throws Exception {
		return entityManager.createQuery("from Negozio").getResultList();

	}

	@Override
	public Negozio get(long id) throws Exception {
		return entityManager.find(Negozio.class, id);
	}

	@Override
	public void update(Negozio o) throws Exception {
		if (o == null) {
			throw new Exception("Problema valore in input");
		}

		o = entityManager.merge(o);

	}

	@Override
	public void insert(Negozio o) throws Exception {
		if (o == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.persist(o);

	}

	@Override
	public void delete(Negozio o) throws Exception {
		if (o == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.remove(entityManager.merge(o));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Negozio> findByExample(Negozio o) throws Exception {
		if (o == null) {
			throw new Exception("Problema valore in input");
		}

		Session session = (Session) entityManager.getDelegate();
		Example negozioExample = Example.create(o).excludeZeroes();
		Criteria criteria = session.createCriteria(Negozio.class).add(negozioExample);
		return criteria.list();
	}

}
