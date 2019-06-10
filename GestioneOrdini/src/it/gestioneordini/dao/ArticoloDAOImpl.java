package it.gestioneordini.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;

import it.gestioneordini.model.Articolo;
import it.gestioneordini.model.Categoria;

public class ArticoloDAOImpl implements ArticoloDAO{
	
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Articolo> list() throws Exception {
		return entityManager.createQuery("from Articolo").getResultList();
	}

	@Override
	public Articolo get(long id) throws Exception {
		return entityManager.find(Articolo.class, id);
	}

	@Override
	public void update(Articolo o) throws Exception {
		if (o == null) {
			throw new Exception("Problema valore in input");
		}
		o = entityManager.merge(o);
	}

	@Override
	public void insert(Articolo o) throws Exception {
		if (o == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.persist(o);
	}

	@Override
	public void delete(Articolo o) throws Exception {
		if (o == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(o));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Articolo> findByExample(Articolo o) throws Exception {
		if (o == null) {
			throw new Exception("Problema valore in input");
		}

		Session session = (Session) entityManager.getDelegate();
		Example articoloExample = Example.create(o).excludeZeroes();
		Criteria criteria = session.createCriteria(Articolo.class).add(articoloExample);
		return criteria.list();
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public int findSommaPrezziDegliArticoliDiUnaCategoria(Categoria input) throws Exception {
		if(input == null) {
			throw new Exception("Problema valore input");
		}
		Query query = entityManager.createQuery("select sum(a.prezzoSingolo) from Articolo a join a.categorie c where c like :categ ");
		query.setParameter("categ", input);
		int sum =((Number) query.getSingleResult()).intValue();
		return sum;
	}
	
}
