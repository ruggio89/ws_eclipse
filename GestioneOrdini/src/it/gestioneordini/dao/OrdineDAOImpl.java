package it.gestioneordini.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;

import it.gestioneordini.model.Categoria;
import it.gestioneordini.model.Ordine;

public class OrdineDAOImpl implements OrdineDAO{
	
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Ordine> list() throws Exception {
		return entityManager.createQuery("from Ordine").getResultList();
	}

	@Override
	public Ordine get(long id) throws Exception {
		return entityManager.find(Ordine.class, id);
	}

	@Override
	public void update(Ordine o) throws Exception {
		if (o == null) {
			throw new Exception("Problema valore in input");
		}
		o = entityManager.merge(o);
	}

	@Override
	public void insert(Ordine o) throws Exception {
		if (o == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.persist(o);
	}

	@Override
	public void delete(Ordine o) throws Exception {
		if (o == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(o));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ordine> findByExample(Ordine o) throws Exception {
		if (o == null) {
			throw new Exception("Problema valore in input");
		}

		Session session = (Session) entityManager.getDelegate();
		Example ordineExample = Example.create(o).excludeZeroes();
		Criteria criteria = session.createCriteria(Ordine.class).add(ordineExample);
		return criteria.list();
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ordine> findOrdiniByCategoria(Categoria input) throws Exception {
		if(input == null) {
			throw new Exception("Problema valore input");
		}
		Query query = entityManager.createQuery("select o from Ordine o join fetch o.articoli a join fetch a.categorie c where c like :categ group by o");
		query.setParameter("categ", input);
		
		return query.getResultList();
	}

}
